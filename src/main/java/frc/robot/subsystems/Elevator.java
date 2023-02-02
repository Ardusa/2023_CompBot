package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.sensors.CANCoder;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Elevator extends SubsystemBase {
    private static Elevator Instance;
    private final TalonSRX PL_xMod = new TalonSRX(-1);
    private final TalonSRX PL_yMod = new TalonSRX(-1);
    private final TalonSRX PL_extendMod = new TalonSRX(-1);
    private final CANCoder PL_xCoder = new CANCoder(-1);
    private final CANCoder PL_yCoder = new CANCoder(-1);
    private final CANCoder PL_extCoder = new CANCoder(-1);

    private final TalonSRX PL_motor = new TalonSRX(Constants.elevatorMotor_ID);
    private final CANCoder PL_encoder = new CANCoder(Constants.elevatorMotorEncoder_ID);

    public Elevator() {}

    public static Elevator getInstance() {
        if (Instance == null) {
            Instance = new Elevator();
        }
        return Instance;
    }

    public double getElevXDeg() {
        return PL_xCoder.getPosition();
    }

    public double getElevYDeg() {
        return PL_yCoder.getPosition();
    }

    public double getElevExtension() {
        return PL_extCoder.getPosition();
    }

    public void setElevatorX(double speed) {
        PL_xMod.set(ControlMode.PercentOutput, speed);
    }

    public void setElevatorY(double speed) {
        PL_yMod.set(ControlMode.PercentOutput, speed);
    }

    public void setElevatorExt(double speed) {
        PL_extendMod.set(ControlMode.PercentOutput, speed);
    }

    public void elevatorToggle(boolean on) {
        double speed;
        if (on) {
            speed = Constants.ELEVATOR_SPEED;
        } else {
            speed = 0;
        }
        PL_motor.set(ControlMode.PercentOutput, speed);
    }

    public double elevatorEncoderVal() {
        return PL_encoder.getPosition();
    }

    public void elevatorEncoderZero() {
        PL_encoder.setPosition(0);
    }
}
