// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide
 * numerical or boolean
 * constants. This class should not be used for any other purpose. All constants
 * should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>
 * It is advised to statically import this class (or one of its inner classes)
 * wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {

    public static final class DriveConstants {
        public static final int LEFT_MASTER_MOTOR_PWM = 0;
        public static final int RIGHT_MASTER_MOTOR_PWM = 1;
    }

    public static final class JoystickConstants {
        public static final int JOYSTICK_PORT = 0;

        public static final int ARCADE_DRIVE_SPEED_AXIS = 1;
        public static final int ARCADE_DRIVE_TURN_AXIS = 4;

        public static final int ARCADE_DRIVE_REVERSE_BTN = 7;
        public static final int ARCADE_DRIVE_INVERT_BTN = 8;
    }

    public static final class PanelConstants {
        public static final int PANEL_PORT = 1;
    }

    public static final class F310Constants {
        public static final int F310_PORT = 2;
    }

    public static final class IntakeConstants {
        public static final int INTAKE_MOTOR_ID = 7;
        public static final double INTAKE_SLEW = 5;

        // intake arm
        public static final int ARM_MOTOR_PWM = 2;
    }

    public static final class IndexerConstants {
        public static final int INDEXER_MOTOR_ID = 8;
    }

    public static final class TriggerConstants {
        public static final int TRIGGER_MOTOR_PWM = 3;
    }

    public static final class ShooterConstants {
        public static final int SHOOTER_MOTOR_ID = 10;
    }

    public static final class ClimberConstants {
        public static final int FIXED_CLIMBER_MOTOR_ID = 6;
        public static final int ELEVATOR_MOTOR_PWM = 4;
    }

}
