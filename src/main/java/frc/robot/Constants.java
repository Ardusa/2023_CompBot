// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    //Drivetrain Constants
    public static final int drivetrainLeftMotorMaster_ID = 1;
    public static final int drivetrainLeftMotorSlave_ID = 2;
    public static final int drivetrainRightMotorMaster_ID = 3;
    public static final int drivetrainRightMotorSlave_ID = 4;
    public static final double DRIVETRAIN_MOD = 1;
    //Intake Constants
    public static final int intakeLeftMotor_ID = 0;
    public static final int intakeRightMotor_ID = 0;
    public static final int intakeLeftMotorArm_ID = 0;
    public static final int intakeRightMotorArm_ID = 0;
    public static final double INTAKE_MOD = 1;
    public static final double INTAKE_SPEED = 0.5;
    //Crane Constants
    public static final int craneMotor_ID = 0;
    public static final int craneMotorEncoder_ID = 0;
    //Elevator Constants
    public static final int elevatorMotor_ID = 0;
    public static final int elevatorMotorEncoder_ID = 0;
    public static final double CMD_ELEVATOR_EXTEND_MOD = 1;
    public static final double CMD_ELEVATOR_X_MOD = 1;
    public static final double CMD_ELEVATOR_Y_MOD = 1;
    public static final double ELEVATOR_SPEED = 0.5;

    public static final double MAN_ELEVATOR_EXTEND_MOD = 1;
    public static final double MAN_ELEVATOR_X_MOD = 1;
    public static final double MAN_ELEVATOR_Y_MOD = 1;

}
