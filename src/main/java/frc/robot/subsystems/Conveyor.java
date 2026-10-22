package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Conveyor extends SubsystemBase {
    private final PWMSparkMax m_topMotor = new PWMSparkMax(Constants.ConveyorConstants.CONVEYOR_MOTOR_TOP_CAN_ID);
    private final PWMSparkMax m_bottomMotor = new PWMSparkMax(Constants.ConveyorConstants.CONVEYOR_MOTOR_BOTTOM_CAN_ID);

    public Conveyor(boolean isInverted){
        m_topMotor.setInverted(isInverted);
    }

    public void setConveyorVoltage(){
        m_topMotor.setVoltage(5);
        m_bottomMotor.setVoltage(5);
    }
    
    public void stopConveyor(){
        m_topMotor.setVoltage(0);
        m_bottomMotor.setVoltage(0);
    }


}
