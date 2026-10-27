package frc.robot.subsystems;

import org.littletonrobotics.junction.Logger;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Drive extends SubsystemBase{
  private DifferentialDrive m_robotDrive;
  private final PWMSparkMax m_leftMotor = new PWMSparkMax(Constants.DriverConstants.DRIVER_MOTOR_LEFT_CAN_ID);
  private final PWMSparkMax m_rightMotor = new PWMSparkMax(Constants.DriverConstants.DRIVER_MOTOR_RIGHT_CAN_ID);

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

  public void setDriveVoltage(double voltage){
    m_leftMotor.setVoltage(-voltage);
    m_rightMotor.setVoltage(voltage);
  }

  public void periodic(){
    Logger.recordOutput("Drive/Testing", "Hi");
  }
}
