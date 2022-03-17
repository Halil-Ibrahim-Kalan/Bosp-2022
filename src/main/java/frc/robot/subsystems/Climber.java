// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.VictorSPXControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ClimberConstants;

public class Climber extends SubsystemBase {
  /** Creates a new Climbers. */
  VictorSPX fixedMotor;
  CANSparkMax elevatorMotor1;
  CANSparkMax elevatorMotor2;
  MotorControllerGroup elevatorMotors;
  Encoder encoder;
  double motorWheel = 1.5 / 2.54; //  (1 inch 2.54cm)
  double cpr = 7; // ppr 7

  public Climber() {
    fixedMotor = new VictorSPX(ClimberConstants.FIXED_CLIMBER_MOTOR_ID);
    elevatorMotor1 = new CANSparkMax(ClimberConstants.ELEVATOR_MOTOR1_PWM, MotorType.kBrushed);
    elevatorMotor2 = new CANSparkMax(ClimberConstants.ELEVATOR_MOTOR2_PWM, MotorType.kBrushed);
    elevatorMotor2.setInverted(true);
    
    elevatorMotors = new MotorControllerGroup(elevatorMotor1, elevatorMotor2);
    elevatorMotors.setInverted(true);
    encoder = new Encoder(
      ClimberConstants.ENCODER_CHANNEL_A, 
      ClimberConstants.ENCODER_CHANNEL_B, 
      ClimberConstants.ENCODER_REVERSE_DIRECTION
    );                                          
  }

  public void resetEncoder() {
    encoder.reset();
  }

  public double getDistanceTraveled() {
    encoder.setDistancePerPulse(Math.PI*motorWheel/cpr);
    return encoder.getDistance() * (motorWheel / 1);
  }

  public void runElevator(double speed) {
    elevatorMotors.set(speed);
  }

  public void runRope(double m_speed) {
    fixedMotor.set(VictorSPXControlMode.PercentOutput, m_speed);;
  }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("Rope Encoder", getDistanceTraveled());
  }
}
