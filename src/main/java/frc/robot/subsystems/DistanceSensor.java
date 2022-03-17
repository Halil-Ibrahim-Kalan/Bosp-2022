// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DistanceSensor extends SubsystemBase {
  /** Creates a new DistanceSensor. */
  Ultrasonic ultrasonic;
  public DistanceSensor() {
    // ultrasonic=new Ultrasonic(pingChannel, echoChannel)
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
