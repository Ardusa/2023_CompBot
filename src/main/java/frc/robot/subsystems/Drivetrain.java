package frc.robot.subsystems;
import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Drivetrain extends SubsystemBase {
    private static Drivetrain Instance;
    private final TalonSRX PL_lm1 = new TalonSRX(Constants.drivetrainLeftMotorMaster_ID);
    private final TalonSRX PL_lm2 = new TalonSRX(Constants.drivetrainLeftMotorSlave_ID);
    private final TalonSRX PL_rm1 = new TalonSRX(Constants.drivetrainRightMotorMaster_ID);
    private final TalonSRX PL_rm2 = new TalonSRX(Constants.drivetrainRightMotorSlave_ID);

    public Drivetrain() {
        PL_lm2.follow(PL_lm1);
        PL_rm2.follow(PL_rm1);

        PL_rm1.setInverted(true);
//        PL_rm2.setInverted(true);
    }

    public static Drivetrain getInstance() {
        if (Instance == null) {
            Instance = new Drivetrain();
        }
        return Instance;
    }

    public void periodic() {

    }

    public void simulationPeriodic() {

    }

    public void setSpeeds(double lm1, double rm1) {
        PL_lm1.set(TalonSRXControlMode.PercentOutput, lm1);
//        PL_lm2.set(TalonSRXControlMode.PercentOutput, lm2);
        PL_rm1.set(TalonSRXControlMode.PercentOutput, rm1);
//        PL_rm2.set(TalonSRXControlMode.PercentOutput, rm2);
    }

}
