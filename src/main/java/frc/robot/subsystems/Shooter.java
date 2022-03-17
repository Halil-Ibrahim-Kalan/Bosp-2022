// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ShooterConstants;

public class Shooter extends SubsystemBase {
  /** Creates a new Shooter. */
  WPI_VictorSPX shooterMotor;
  public Shooter() {
    shooterMotor = new WPI_VictorSPX(ShooterConstants.SHOOTER_MOTOR_ID);
    shooterMotor.configFactoryDefault();
  }

  public void runShooter(double speed){
    shooterMotor.set(speed);
  }

  public void runShooterVoltage(double voltage) {
    shooterMotor.setVoltage(voltage);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
