// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.VictorSPXControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.TriggerConstants;

public class Trigger extends SubsystemBase {
  /** Creates a new Trigger. */
  VictorSPX triggerMotor;

  public Trigger() {
    triggerMotor = new VictorSPX(TriggerConstants.TRIGGER_MOTOR_PWM);
  }

  public void runTrigger(double speed) {
    triggerMotor.set(VictorSPXControlMode.PercentOutput, speed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
