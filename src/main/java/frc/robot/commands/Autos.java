// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.Conveyor;
import frc.robot.subsystems.ConveyorSim;
import frc.robot.subsystems.Drive;
import frc.robot.subsystems.DriveSim;
import frc.robot.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;

public final class Autos {
  /** Example static factory for an autonomous command. */
  public static Command exampleAuto(ExampleSubsystem subsystem) {
    return Commands.sequence(subsystem.exampleMethodCommand(), new ExampleCommand(subsystem));
  }

  public static Command driveAuto(DriveSim drive, ConveyorSim conveyor, double time, double speed) {
    return Commands.startEnd(
      () -> drive.arcadeDrive(speed, 0), 
      () -> drive.arcadeDrive(0, 0),   
      drive                
    ).withTimeout(time);
  }

  public static Command shootPreloadAuto(DriveSim drive, ConveyorSim conveyor) {
    return Commands.sequence(
    // 1. Drive to the Power Port
    drive.run(() -> drive.arcadeDrive(0.4, 0))
        .withTimeout(1.0)
        .finallyDo(() -> drive.setDriveVoltage(0)),

    // 2. Score the preloaded Flux
    conveyor.startEnd(() -> conveyor.startConveyor(), () -> conveyor.stopConveyor())
        .withTimeout(1.5),

    // 3. Back out across the tape line for the Leave points
    drive.run(() -> drive.arcadeDrive(-0.4, 0))
        .withTimeout(1.0)
        .finallyDo(() -> drive.setDriveVoltage(0))
  );
  }

  public static Command intakeFromMiddleAuto(DriveSim drive, ConveyorSim conveyor) {
    return Commands.sequence(
      drive.run(() -> drive.arcadeDrive(0.4, 45))
           .withTimeout(1.5)
           .finallyDo(() -> drive.arcadeDrive(0, 0))
    );
  }

  public static Command Auto(DriveSim drive, ConveyorSim conveyor) {
    return Commands.sequence(
      Autos.shootPreloadAuto(drive, conveyor),
      Autos.intakeFromMiddleAuto(drive, conveyor)
    );
  }

  private Autos() {
    throw new UnsupportedOperationException("This is a utility class!");
  }
}