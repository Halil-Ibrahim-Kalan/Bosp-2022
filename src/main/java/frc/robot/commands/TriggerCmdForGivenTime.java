// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Trigger;

public class TriggerCmdForGivenTime extends CommandBase {
  /** Creates a new TriggerCmdForGivenTime. */
  Trigger trigger;
  double speed;
  Timer timer;
  double tm;

  public TriggerCmdForGivenTime(Trigger m_trigger, double m_speed, double time) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.trigger = m_trigger;
    this.speed = m_speed;
    this.tm = time;
    timer = new Timer();
    addRequirements(trigger);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    System.out.println("TriggerCmdForGivenTime started!");
    timer.reset();
    timer.start();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    trigger.runTrigger(speed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    System.out.println("TriggerCmdForGivenTime ended!");
    trigger.runTrigger(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if (timer.get() >= tm) {
      return true;
    }
    return false;
  }
}
