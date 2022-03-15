// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.IndexerConstants;

public class Indexer extends SubsystemBase {
  /** Creates a new Indexer. */
  WPI_VictorSPX indexerMotor;

  public Indexer() {
    indexerMotor = new WPI_VictorSPX(IndexerConstants.INDEXER_MOTOR_ID);
    indexerMotor.configFactoryDefault();
  }

  public void runIndexer(double speed) {
    indexerMotor.set(speed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
