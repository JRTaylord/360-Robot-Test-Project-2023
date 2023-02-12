// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.AngleSys;

public class AngleCmd extends CommandBase {
  AngleSys mAngleSys;
  DoubleSupplier angleInput;

  /** Creates a new Subsystem2Command. */
  public AngleCmd(AngleSys mAngleSys, DoubleSupplier input) {
    this.mAngleSys = mAngleSys;
    addRequirements(this.mAngleSys);
    angleInput = input;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double angleChange = angleInput.getAsDouble();
    if (Math.abs(angleChange) > 0.1) {
      mAngleSys.adjustAngle(angleChange);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
