package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class Drive extends SubsystemBase{
  private DifferentialDrive m_robotDrive;
  private final PWMSparkMax m_leftMotor = new PWMSparkMax(Constants.kLeftMotorPort);
  private final PWMSparkMax m_rightMotor = new PWMSparkMax(Constants.kRightMotorPort);

  public Drive() {
    // We need to invert one side of the drivetrain so that positive voltages
    // result in both sides moving forward. Depending on how your robot's
    // gearbox is constructed, you might have to invert the left side instead.

    m_rightMotor.setInverted(true);
    m_robotDrive = new DifferentialDrive(m_leftMotor::set, m_rightMotor::set);
  }
  
  public void drive(double speed, double rotation) {
    m_robotDrive.arcadeDrive(speed, rotation);
  }

  public void stop() {
    m_robotDrive.stopMotor();
  }
}

