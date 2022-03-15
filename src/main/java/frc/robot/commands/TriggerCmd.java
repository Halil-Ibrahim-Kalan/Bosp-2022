// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Trigger;

public class TriggerCmd extends CommandBase {
  /** Creates a new TriggerCmd. */
  Trigger trigger;
  double speed;
  public TriggerCmd(Trigger m_trigger, double m_speed) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.trigger=m_trigger;
    this.speed=m_speed;
    addRequirements(trigger);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    System.out.println("TriggerCmd started!");
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    trigger.runTrigger(speed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    System.out.println("Trigger cmd ended!");
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
