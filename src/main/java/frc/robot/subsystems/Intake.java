package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import frc.robot.Constants;

public class Intake {
    private final PWMSparkMax m_intakeMotor = new PWMSparkMax(Constants.IntakerConstants.INTAKER_MOTOR_CAN_ID);

    public void setIntakeVoltage(double voltage){
        m_intakeMotor.setVoltage(voltage);
    }

    public void stopIntake(){
        m_intakeMotor.setVoltage(0);
    }

}
