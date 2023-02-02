package frc.robot.subsystems;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Driver extends SubsystemBase {
    
    private XboxController driveController = new XboxController(-1);

    public Driver() {
    }

    public double getDriveControllerLY() {
        return driveController.getLeftY();
    }

    public double getDriveControllerRX() {
        return driveController.getRightX();
    }
}
