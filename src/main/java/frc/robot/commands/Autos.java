// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.ConveyorSim;
import frc.robot.subsystems.DriveSim;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.IntakeSim;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;

public final class Autos {
  public static final double DISTANCE_TO_CAPTURE_ZONE_INCHES = 54.5;
  public static final double DRIVE_TIME_SECONDS = 1.82;


  /** Example static factory for an autonomous command. */
  public static Command exampleAuto(ExampleSubsystem subsystem) {
    return Commands.sequence(subsystem.exampleMethodCommand(), new ExampleCommand(subsystem));
  }

  public static Command shootPreloadAuto(DriveSim drive, ConveyorSim conveyor) {
    return Commands.startEnd(() -> conveyor.startConveyor(), () -> conveyor.stopConveyor(), conveyor).withTimeout(3.0);
  }

  public static Command intakeAndScoreFromMiddleAuto(DriveSim drive, ConveyorSim conveyor, IntakeSim intake) {
    return Commands.sequence(
      Commands.startEnd(() -> drive.arcadeDrive(0.0001, 45), () -> drive.arcadeDrive(0, 0))
      .withTimeout(0.1),

      Commands.startEnd(() -> drive.arcadeDrive(0.5, 0.0), () -> drive.arcadeDrive(0, 0), drive).withTimeout(DRIVE_TIME_SECONDS),
        // Run conveyor to intake the game piece
      Commands.startEnd(() -> intake.setIntakeVoltage(5), () -> intake.setIntakeVoltage(5), intake).withTimeout(3.0),

      Commands.startEnd(() -> drive.arcadeDrive(-0.5, 0.0), () -> drive.arcadeDrive(0, 0), drive).withTimeout(DRIVE_TIME_SECONDS),

      Commands.startEnd(() -> drive.arcadeDrive(0.0001, -45), () -> drive.arcadeDrive(0, 0))
      .withTimeout(0.1)
      );
  }

  public static Command Auto(DriveSim drive, ConveyorSim conveyor) {
    return Commands.sequence(
      Autos.shootPreloadAuto(drive, conveyor)
    );
  }

  private Autos() {
    throw new UnsupportedOperationException("This is a utility class!");
  }
}