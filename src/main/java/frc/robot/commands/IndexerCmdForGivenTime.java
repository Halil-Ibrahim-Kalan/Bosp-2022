// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Indexer;

public class IndexerCmdForGivenTime extends CommandBase {
  /** Creates a new IndexerCmdForGivenTime. */
  Indexer indexer;
  double speed;
  Timer timer;
  double time;

  public IndexerCmdForGivenTime(Indexer m_indexer, double m_speed, double m_time) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.indexer = m_indexer;
    this.speed = m_speed;
    this.time = m_time;
    timer = new Timer();
    addRequirements(indexer);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    System.out.println("IndexerCmdForGivenTime started!");
    timer.reset();
    timer.start();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    indexer.runIndexer(speed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    System.out.println("IndexerCmdForGivenTime ended!");
    indexer.runIndexer(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if (timer.get() >= time) {
      return true;
    }
    return false;
  }
}
