package frc.robot.subsystems;

import org.littletonrobotics.junction.Logger;

import edu.wpi.first.math.system.plant.DCMotor;
import edu.wpi.first.math.system.plant.LinearSystemId;
import edu.wpi.first.wpilibj.simulation.DCMotorSim;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ConveyorSim extends SubsystemBase{
     private DCMotorSim conveyorSim = 
        new DCMotorSim(LinearSystemId.createDCMotorSystem(1, 0.5), DCMotor.getMiniCIM(2));

    private double voltage = 0;

     public void startConveyor(){
        voltage = 5;
        conveyorSim.setInputVoltage(voltage);
     }

     public void stopConveyor(){
        voltage = 0;
        conveyorSim.setInputVoltage(voltage);
     }
 
     @Override
     public void simulationPeriodic(){
        conveyorSim.update(0.02);
        Logger.recordOutput("Conveyor/VelocityRPM", conveyorSim.getAngularVelocityRPM());
        Logger.recordOutput("Conveyor/CurrentAmps", conveyorSim.getCurrentDrawAmps());
        Logger.recordOutput("Conveyor/Voltage", voltage);     
    }
}

