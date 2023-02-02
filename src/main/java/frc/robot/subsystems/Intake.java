package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Intake extends SubsystemBase {
    private static Intake Instance;
    private final TalonSRX PL_leftIntake = new TalonSRX(Constants.intakeLeftMotor_ID);
    private final TalonSRX PL_rightIntake = new TalonSRX(Constants.intakeRightMotor_ID);
    private final TalonSRX PL_leftArm = new TalonSRX(Constants.intakeLeftMotorArm_ID);
    private final TalonSRX PL_rightArm = new TalonSRX(Constants.intakeRightMotorArm_ID);


    public Intake() {
        PL_rightIntake.setInverted(true);
        PL_rightIntake.follow(PL_leftIntake);
        PL_rightArm.follow(PL_leftArm);
    }

    public static Intake getInstance() {
        if (Instance == null) {
            Instance = new Intake();
        }
        return Instance;
    }

    public void setIntakeSpeeds(double speed) {
        PL_leftIntake.set(ControlMode.PercentOutput, speed);
        //PL_rightIntake.set(ControlMode.PercentOutput, speed);
    }

    public void setArmSpeeds(double speed) {
        PL_leftArm.set(ControlMode.PercentOutput, speed);
        //PL_rightArm.set(ControlMode.PercentOutput, speed);
    }

    public void zeroIntake() {
        PL_leftIntake.set(ControlMode.PercentOutput, 0);
        //PL_rightIntake.set(ControlMode.PercentOutput, 0);
    }

    public void toggleIntake(boolean on) {
        double speed;
        if (on) {
            speed = Constants.INTAKE_SPEED;
        } else {
            speed = 0;
        }
        PL_leftIntake.set(ControlMode.PercentOutput, speed);
    }
}