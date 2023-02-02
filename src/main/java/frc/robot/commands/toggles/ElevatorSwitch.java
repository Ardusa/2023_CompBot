package frc.robot.commands.toggles;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Elevator;

public class ElevatorSwitch extends CommandBase {
    private final Elevator mElevator;

    public ElevatorSwitch(Elevator mElevator) {
        this.mElevator = mElevator;
        addRequirements(mElevator);
    }

    public void initialize() {
        System.out.println("Elevator Switched On");
        mElevator.elevatorEncoderZero();
    }

    public void execute() {
        mElevator.elevatorToggle(true);
        System.out.println(mElevator.elevatorEncoderVal());
    }

    public void end(boolean interrupted) {
        mElevator.elevatorToggle(false);
        System.out.println("Elevator Switched Off");
    }

    public boolean isFinished() {
        return false;
    }
}
