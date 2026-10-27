package frc.robot.subsystems;

import edu.wpi.first.math.kinematics.DifferentialDriveKinematics;
import edu.wpi.first.math.kinematics.DifferentialDriveWheelSpeeds;
import edu.wpi.first.wpilibj.simulation.DifferentialDrivetrainSim;
import edu.wpi.first.wpilibj.simulation.DifferentialDrivetrainSim.KitbotGearing;
import edu.wpi.first.wpilibj.simulation.DifferentialDrivetrainSim.KitbotMotor;
import edu.wpi.first.wpilibj.simulation.DifferentialDrivetrainSim.KitbotWheelSize;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveSim extends SubsystemBase {
    private DifferentialDrivetrainSim driveSim = 
      DifferentialDrivetrainSim.createKitbotSim(
      KitbotMotor.kSingleCIMPerSide,
      KitbotGearing.k10p71,
      KitbotWheelSize.kSixInch,
      null);

    DifferentialDriveKinematics kinematics = new DifferentialDriveKinematics(0.5);

    public DriveSim(){

    }

    public void arcadeDrive(double speed, double rotation){
        DifferentialDriveWheelSpeeds wheelSpeeds = new DifferentialDriveWheelSpeeds()
    }
}
