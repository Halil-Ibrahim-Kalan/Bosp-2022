// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Shooter;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Shooter;

public class UpperHubCmd extends CommandBase {
  /** Creates a new ShooterCmd. */
  Shooter shooter;
  double speed;
  public UpperHubCmd(Shooter m_shooter, double m_speed) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.shooter= m_shooter;
    this.speed=m_speed;
    addRequirements(shooter);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    System.out.println("UpperHubCmd started!");
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    shooter.runShooter(speed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    System.out.println("UpperHubCmd ended!");
    shooter.runShooter(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
