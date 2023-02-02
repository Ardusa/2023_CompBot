package frc.robot.commands.toggles;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Intake;

public class IntakeSwitch extends CommandBase {
    private final Intake mIntake;

    public IntakeSwitch(Intake mIntake) {
        this.mIntake = mIntake;
        addRequirements(mIntake);
    }

    @Override
    public void initialize() {
        System.out.println("Intake Switched On");
    }

    @Override
    public void execute() {
        mIntake.toggleIntake(true);
    }

    @Override
    public void end(boolean interrupted) {
        mIntake.toggleIntake(false);
        System.out.println("Intake Switched Off");
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}

