package frc.robot.subsystems;

import org.littletonrobotics.junction.Logger;

import edu.wpi.first.wpilibj.simulation.DifferentialDrivetrainSim;
import edu.wpi.first.wpilibj.simulation.DifferentialDrivetrainSim.KitbotGearing;
import edu.wpi.first.wpilibj.simulation.DifferentialDrivetrainSim.KitbotMotor;
import edu.wpi.first.wpilibj.simulation.DifferentialDrivetrainSim.KitbotWheelSize;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveSim extends SubsystemBase {
    public DifferentialDrivetrainSim driveSim = 
        DifferentialDrivetrainSim.createKitbotSim(
            KitbotMotor.kSingleCIMPerSide, 
            KitbotGearing.k10p71,
            KitbotWheelSize.kSixInch,
            null
        );

    public DriveSim() {

    }

    public void arcadeDrive(double speed, double rotation) {}

    public void tankDrive(double rSpeed, double lSpeed) {
        driveSim.setInputs(rSpeed, lSpeed);
    }

    @Override
    public void periodic() {
        driveSim.update(0.02);

        Logger.recordOutput("", driveSim.getPose());
        Logger.recordOutput("Drive/Current", driveSim.getCurrentDrawAmps());
    }
}
