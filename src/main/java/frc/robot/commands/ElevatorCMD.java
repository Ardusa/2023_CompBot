package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.Elevator;

public class ElevatorCMD extends CommandBase {
    
    private final Elevator mElevator;
    private double forwards, backwards;

    public ElevatorCMD(DoubleSupplier f, DoubleSupplier b) {
        mElevator = Elevator.getInstance();

        forwards = f.getAsDouble();
        backwards = b.getAsDouble();

        addRequirements(mElevator);
    }

    public void initialize() {
        System.out.println("Elevator command");
    }

    public void execute() {
        mElevator.setElevatorExt((forwards-backwards)*Constants.MAN_ELEVATOR_EXTEND_MOD);
    }

    public void end(boolean interrupted) {}

    public boolean isFinished() {
        return false;
    }
}
