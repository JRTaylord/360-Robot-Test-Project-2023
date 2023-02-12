// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ExtendSys extends SubsystemBase {
  private double extend = 0.5;

  private static ExtendSys instance;

  public static ExtendSys getInstance() {
    if (instance == null) {
      instance = new ExtendSys();
    }
    return instance;
  }

  /** Creates a new Subsystem1. */
  private ExtendSys() {
  }

  public void adjustExtend(double changeExtend) {
    extend = extend + changeExtend;
  }

  public double getExtend() {
    return extend;
  }

  private double getFeedForward() {
    return Math.sin(Math.toRadians(AngleSys.getInstance().getAngle()));
  }

  @Override
  public void periodic() {
    SmartDashboard.putNumber("Subsystem 1 Extend", extend);
    SmartDashboard.putNumber("Subsystem 1 FF Value", getFeedForward());
  }
}
