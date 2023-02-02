package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.sensors.CANCoder;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Crane extends SubsystemBase {
    
    private static Crane instance;
    private final TalonSRX PL_motorJaw = new TalonSRX(Constants.craneMotor_ID);
    private final CANCoder PL_jawCoder = new CANCoder(Constants.craneMotorEncoder_ID);

    public Crane() {}

    public static Crane getInstance() {
        if (instance == null) {
            instance = new Crane();
        }
        return instance;
    }

    public double getJawPos() {
        return PL_jawCoder.getPosition();
    }

    public void setJaw(double speed) {
        PL_motorJaw.set(ControlMode.PercentOutput, speed);
    }
}
