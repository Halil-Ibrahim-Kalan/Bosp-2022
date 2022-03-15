// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Autonomous;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.Shooter.UpperHubCmd;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Indexer;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.Trigger;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class Autonomous extends SequentialCommandGroup {
  /** Creates a new Autonomous. */
  public Autonomous(Shooter m_shooter, Trigger m_trigger, Indexer m_indexer, DriveTrain m_drive) {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    addCommands(
        new UpperHubCmd(m_shooter, 1).withTimeout(1.5),
        new ParallelCommandGroup(
            new RunCommand(() -> m_indexer.runIndexer(0.5), m_indexer),
            new RunCommand(() -> m_trigger.runTrigger(0.5), m_trigger),
            new RunCommand(() -> m_shooter.runShooter(0.8), m_shooter)) {
          @Override
          public void end(boolean interrupted) {
            m_indexer.runIndexer(0);
            m_trigger.runTrigger(0);
            m_shooter.runShooter(0);
          }
        }.withTimeout(2),
        new InstantCommand(() -> m_drive.tankDrive(-0.6, -0.6), m_drive).withTimeout(1));
  }
}