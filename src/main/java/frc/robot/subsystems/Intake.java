// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.math.filter.SlewRateLimiter;
import edu.wpi.first.wpilibj.motorcontrol.PWMTalonSRX;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.IntakeConstants;

public class Intake extends SubsystemBase {
  /** Creates a new Intake. */
  WPI_VictorSPX intakeMotor;
  PWMTalonSRX intakeArm;
  SlewRateLimiter filter;

  public Intake() {
    intakeMotor = new WPI_VictorSPX(IntakeConstants.INTAKE_MOTOR_ID);
    intakeArm = new PWMTalonSRX(IntakeConstants.ARM_MOTOR_PWM);
    filter = new SlewRateLimiter(SmartDashboard.getNumber("Intake Slew Rate", IntakeConstants.INTAKE_SLEW));
    intakeMotor.configFactoryDefault();
  }

  // filter olayı ne yapıyor merak ettim bu yüzden ekledim
  public void setMotor(double intakeSpeed) {
    intakeSpeed = filter.calculate(intakeSpeed);
    intakeMotor.set(intakeSpeed);
    SmartDashboard.putNumber("Intake Speed", intakeSpeed);
  }

  public void setArm(double armSpeed) {
    intakeArm.set(armSpeed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
