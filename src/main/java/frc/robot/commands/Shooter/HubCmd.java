// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Shooter;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.ShooterCmd;
import frc.robot.subsystems.Indexer;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.Trigger;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class HubCmd extends SequentialCommandGroup {
  /** Creates a new HubCmd. */
  public HubCmd(Shooter m_shooter, Trigger m_trigger, Indexer m_indexer, double shooterSpeed) {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    addCommands(new ShooterCmd(m_shooter, shooterSpeed).withTimeout(1.5),
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
    });
  }
}
