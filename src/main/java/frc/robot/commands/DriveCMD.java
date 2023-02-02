// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.Constants;
import frc.robot.subsystems.Drivetrain;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;

/** An example command that uses an example subsystem. */
public class DriveCMD extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final Drivetrain mDrivetrain;
//  private static Constants constants = new Constants();
  private double x, y;


  public DriveCMD(DoubleSupplier LY, DoubleSupplier RX) {
    mDrivetrain = Drivetrain.getInstance();

    y = LY.getAsDouble();
    x = RX.getAsDouble();
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(mDrivetrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    System.out.println("Drive command");
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double left = (y+x) * Constants.DRIVETRAIN_MOD;
    double right = (y-x) * Constants.DRIVETRAIN_MOD;
//    mDrivetrain.setSpeeds(left, left, right, right);
    mDrivetrain.setSpeeds(left, right);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
