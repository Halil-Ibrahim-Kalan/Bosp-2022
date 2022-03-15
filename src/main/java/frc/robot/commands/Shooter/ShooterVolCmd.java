// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Shooter;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Shooter;

public class ShooterVolCmd extends CommandBase {
  /** Creates a new ShooterCmd. */
  Shooter shooter;
  double voltage;
  public ShooterVolCmd(Shooter m_shooter, double m_voltage) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.shooter= m_shooter;
    this.voltage=m_voltage;
    addRequirements(shooter);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    System.out.println("ShooterVolCmd started!");
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    shooter.runShooterVoltage(voltage);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    System.out.println("ShooterVolCmd ended!");
    shooter.runShooterVoltage(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
