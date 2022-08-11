package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import harkerrobolib.wrappers.HSTalon;

public class Elevator extends SubsystemBase {
    private static Elevator instance;
    
    private static final int hsmID = 0;
    private static final int hsfID = 0;
    private static final int v1ID = 0;
    private static final int v2ID = 0;

    //instance variable for the motor
    private HSTalon hsmast;
    private HSTalon hsfoll;
    private VictorSPX vic1;
    private VictorSPX vic2;

    private static final boolean mastINV = false;
    private static final boolean follINV = false;
    private static final boolean vic1INV = false;
    private static final boolean vic2INV = false;
    
    private Elevator() {
        hsmast = new HSTalon(hsmID);
        hsfoll = new HSTalon(hsfID);
        vic1 = new VictorSPX(v1ID);
        vic2 = new VictorSPX(v2ID);
        hsfoll.follow(hsmast);
        vic1.follow(hsmast);
        vic2.follow(hsmast);
        hsmast.setInverted(mastINV);
        hsfoll.setInverted(follINV);
        vic1.setInverted(vic1INV);
        vic2.setInverted(vic2INV);
    }

    public HSTalon getHSMast() {
        return hsmast;
    }
    public HSTalon getHSfoll() {
        return hsfoll;
    }
    public VictorSPX getVic1() {
        return vic1;
    }
    public VictorSPX getVic2() {
        return vic2;
    }

    public void setPercentOutput(double output) {
        hsmast.set(ControlMode.PercentOutput, output);
    }

    public static Elevator getInstance() {
        if (instance == null) {
            instance = new Elevator();
        }
        return instance;
    }
}
