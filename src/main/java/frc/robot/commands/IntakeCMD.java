package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.Intake;

public class IntakeCMD extends CommandBase {
    private final Intake mIntake;
    private double forwards, backwards;

    public IntakeCMD(DoubleSupplier f, DoubleSupplier b) {
        mIntake = Intake.getInstance();

        forwards = f.getAsDouble();
        backwards = b.getAsDouble();

        addRequirements(mIntake);
    }

    public void initialize() {
        System.out.println("Intake command");
    }

    public void execute() {
        mIntake.setIntakeSpeeds((forwards-backwards)*Constants.INTAKE_MOD);
    }

    public void end(boolean interrupted) {}

    public boolean isFinished() {
        return false;
    }
}
