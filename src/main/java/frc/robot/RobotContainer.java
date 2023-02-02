// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;

import frc.robot.commands.DriveCMD;
import frc.robot.commands.ElevatorCMD;
import frc.robot.commands.IntakeCMD;
import frc.robot.commands.toggles.ElevatorSwitch;
import frc.robot.commands.toggles.IntakeSwitch;
import frc.robot.subsystems.Driver;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Elevator;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Manip;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RepeatCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;


/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private static Constants constants = new Constants();
  private final Drivetrain mDrivetrain = new Drivetrain();
  private final Intake mIntake = new Intake();
  private final Elevator mElevator = new Elevator();
  private final Driver mDriver = new Driver();
  private final Manip mManip = new Manip();

  //Triggers
  private final XboxController xDrive = new XboxController(0);
  private final XboxController xManip = new XboxController(1);

  private final JoystickButton manipRT = new JoystickButton(xManip, XboxController.Axis.kRightTrigger.value);
  private final JoystickButton manipLT = new JoystickButton(xManip, XboxController.Axis.kLeftTrigger.value);
  private final JoystickButton manipRB = new JoystickButton(xManip, XboxController.Button.kRightBumper.value);
  private final JoystickButton manipLB = new JoystickButton(xManip, XboxController.Button.kLeftBumper.value);
  private final JoystickButton manipRX = new JoystickButton(xManip, XboxController.Axis.kRightX.value);
  private final JoystickButton manipRY = new JoystickButton(xManip, XboxController.Axis.kRightY.value);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  
   private void configureButtonBindings() {
    mDrivetrain.setDefaultCommand(new DriveCMD(
        () -> mDriver.getDriveControllerLY(),
        () -> mDriver.getDriveControllerRX()
    )
    );

    //Intake Switched ON if A is pressed
    new JoystickButton(xDrive, XboxController.Button.kA.value).whileTrue(new IntakeSwitch(mIntake));
    //Elevator Switched ON if B is pressed
    new JoystickButton(xDrive, XboxController.Button.kB.value).whileTrue(new ElevatorSwitch(mElevator));

    /**
    RepeatCommand.whileTrue(new ElevatorCMD(
      () -> mManip.getRTrigger(),
      () -> mManip.getLTrigger()
      //      () -> mManip.getRX(),
      //      () -> mManip.getRY()
    )
    );

    (manipRT.or(manipLT).or(manipRX).or(manipRY).whileTrue(new ElevatorCMD(
      () -> mManip.getRTrigger(),
      () -> mManip.getLTrigger()
      //      () -> mManip.getRX(),
      //      () -> mManip.getRY()
    )
    )
    );

    RepeatCommand.manipRB.or(manipLB).whileTrue(new IntakeCMD(
      () -> mManip.getRBumper()?1:0,
      () -> mManip.getLBumper()?1:0
      )
    );
    */
  
  }

  /**
   Use this to pass the autonomous command to the main {@link Robot} class.
  
   @return the command to run in autonomous
    */

  
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return null;
  }
}

