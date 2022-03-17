// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Autonomous;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.ArcadeDriveCmd;
import frc.robot.commands.Shooter.HubCmd;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Indexer;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.Trigger;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class Auto2Ball extends SequentialCommandGroup {
  /** Creates a new Auto2Ball. */
  public Auto2Ball(Shooter m_shooter, Trigger m_trigger, Intake m_intake, Indexer m_indexer, DriveTrain m_drive) {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    addCommands(
      new ParallelCommandGroup(
        new RunCommand(() -> m_drive.tankDrive(-0.6, -0.6), m_drive),
        new RunCommand(() -> m_indexer.runIndexer(1), m_indexer),
        new RunCommand(() -> m_intake.setMotor(1), m_intake)) {
      @Override
      public void end(boolean interrupted) {
        m_drive.tankDrive(0, 0);
        m_indexer.runIndexer(0);
        m_intake.setMotor(0);
      }
    }.withTimeout(2),
    new ArcadeDriveCmd(m_drive, () -> 0, () -> 0.4).withTimeout(2),
    new HubCmd(m_shooter, m_trigger, m_indexer, 0.8).withTimeout(2)
    );
  }
}
