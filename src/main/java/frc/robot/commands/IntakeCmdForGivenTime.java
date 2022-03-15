// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Intake;

public class IntakeCmdForGivenTime extends CommandBase {
  /** Creates a new IntakeCmdForGivenTime. */
  Intake intake;
  double intakeSpeed;
  Timer timer;
  double tm;

  public IntakeCmdForGivenTime(Intake m_intake, double speed, double time) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.intake = m_intake;
    this.intakeSpeed = speed;
    this.tm = time;
    timer = new Timer();
    addRequirements(intake);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    System.out.println("IntakeCmdForGivenTime started!");
    timer.reset();
    timer.start();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    intake.setMotor(intakeSpeed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    System.out.println("IntakeCmdForGivenTime ended!");
    intake.setMotor(0);
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
