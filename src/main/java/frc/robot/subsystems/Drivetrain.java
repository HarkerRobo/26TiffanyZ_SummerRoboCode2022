package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import harkerrobolib.wrappers.HSTalon;

public class Drivetrain extends SubsystemBase {
    //singleton variable
    private static Drivetrain instance;

    //constant for motor device id
    private static final int MOTOR_IDLM = 0;
    private static final int MOTOR_IDRM = 0;
    private static final int MOTOR_IDLF = 0;
    private static final int MOTOR_IDRF = 0;

    //instance variable for the motor
    private HSTalon motorLM;
    private HSTalon motorRM;
    private VictorSPX motorLF;
    private VictorSPX motorRF;

    private static final boolean LMinvert = false;
    private static final boolean RMinvert = false;
    private static final boolean LFinvert = false;
    private static final boolean RFinvert = false;

    private Drivetrain() {
        motorLM = new HSTalon(MOTOR_IDLM);
        motorRM = new HSTalon(MOTOR_IDRM);
        motorLF = new VictorSPX(MOTOR_IDLF);
        motorRF = new VictorSPX(MOTOR_IDRF);
        motorLF.follow(motorLM);
        motorRF.follow(motorRF);
        motorLM.setInverted(LMinvert);
        motorRM.setInverted(RMinvert);
        motorLF.setInverted(LFinvert);
        motorRF.setInverted(RFinvert);
    }

    //getter method for the motors
    public HSTalon getMotorLM() {
        return motorLM;
    }
    public HSTalon getMotorRM() {
        return motorRM;
    }
    public VictorSPX getMotorLF() {
        return motorLF;
    }
    public VictorSPX getMotorRF() {
        return motorRF;
    }

    public void setArcadeDrive(double speed, double turn) {
        motorLM.set(ControlMode.PercentOutput, speed+turn);
        motorRM.set(ControlMode.PercentOutput, speed-turn);
    }

    //returns the drivetrain instance
    public static Drivetrain getInstance() {
        if (instance == null) {
            instance = new Drivetrain();
        }
        return instance;
    }
}