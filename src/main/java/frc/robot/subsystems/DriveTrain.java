// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.PWMTalonSRX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DriveConstants;

public class DriveTrain extends SubsystemBase {
  /** Creates a new DriveTrain. */
  PWMTalonSRX leftMotor;
  PWMTalonSRX rightMotor;
  DifferentialDrive m_drive;

  public DriveTrain() {
    leftMotor = new PWMTalonSRX(DriveConstants.LEFT_MASTER_MOTOR_PWM);
    rightMotor = new PWMTalonSRX(DriveConstants.RIGHT_MASTER_MOTOR_PWM);
    m_drive = new DifferentialDrive(leftMotor, rightMotor);
  }

  public void arcadeDrive(double xSpeed, double zRotation) {
    m_drive.arcadeDrive(xSpeed, zRotation);
  }

  public void tankDrive(double leftSpeed, double rightSpeed) {
    m_drive.tankDrive(leftSpeed, rightSpeed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
