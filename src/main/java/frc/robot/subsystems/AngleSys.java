// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class AngleSys extends SubsystemBase {
  private double angle = 0.0;

  private static AngleSys instance;

  public static AngleSys getInstance() {
    if (instance == null) {
      instance = new AngleSys();
    }
    return instance;
  }

  /** Creates a new Subsystem2. */
  private AngleSys() {
  }

  public void adjustAngle(double angleChange) {
    angle = angle + angleChange;
  }

  public double getAngle() {
      return angle;
  }

  private double getFeedForward() {
    return 5.0 * ExtendSys.getInstance().getExtend() * Math.cos(Math.toRadians(angle));
  }

  @Override
  public void periodic() {
    SmartDashboard.putNumber("Subsystem 2 Angle", angle);
    SmartDashboard.putNumber("Subsystem 2 FF Value", getFeedForward());
  }
}
