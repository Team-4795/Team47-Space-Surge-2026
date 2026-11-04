package frc.robot.subsystems;

import org.littletonrobotics.junction.Logger;

import edu.wpi.first.math.system.plant.DCMotor;
import edu.wpi.first.math.system.plant.LinearSystemId;
import edu.wpi.first.wpilibj.simulation.DCMotorSim;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class IntakeSim extends SubsystemBase {
    private DCMotorSim intakeSim =
        new DCMotorSim(LinearSystemId.createDCMotorSystem(1, 0.5), DCMotor.getMiniCIM(1));

    public void setIntakeVoltage(double volts) {
        intakeSim.setInputVoltage(volts);
    }  
    
    @Override
    public void periodic() {
        intakeSim.update(0.02);

        Logger.recordOutput("Intake/Velocity", intakeSim.getAngularVelocityRPM());
    }
}
