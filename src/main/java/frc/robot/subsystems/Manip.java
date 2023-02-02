package frc.robot.subsystems;

import edu.wpi.first.wpilibj.XboxController;

public class Manip {
    private final XboxController manipController = new XboxController(-3);

    public Manip() {}

    public double getLTrigger() {
        return manipController.getLeftTriggerAxis();
    }

    public double getRTrigger() {
        return manipController.getRightTriggerAxis();
    }

    public boolean getTriggersActivated() {
        return getRTrigger() > 0 || getLTrigger() > 0;
    }

    //true if [TEST], false if [TEST]
    public boolean getLBumper() {
        return manipController.getLeftBumper();
    }

    public boolean getRBumper() {
        return manipController.getRightBumper();
    }
    //.

    public boolean getA() {
        return manipController.getAButton();
    }

    public boolean getB() {
        return manipController.getBButton();
    }

    public boolean getX() {
        return manipController.getXButton();
    }

    public boolean getY() {
        return manipController.getYButton();
    }

    public double getRX() {
        return manipController.getRightX();
    }

    public double getRY() {
        return manipController.getRightY();
    }
}
