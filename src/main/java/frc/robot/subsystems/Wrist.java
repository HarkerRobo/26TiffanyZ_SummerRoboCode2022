package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import harkerrobolib.wrappers.HSTalon;

public class Wrist extends SubsystemBase {
    private static Wrist instance;

    private static final int masterID = 0;
    private static final int followID = 0;

    //instance variable for the motor
    private HSTalon master;
    private VictorSPX follow;

    private static final boolean mastINV = false;
    private static final boolean follINV = false;

    private Wrist() {
        master = new HSTalon(masterID);
        follow = new VictorSPX(followID);
        follow.follow(master);
        master.setInverted(mastINV);
        follow.setInverted(follINV);
    }

    public HSTalon getMaster() {
        return master;
    }
    public VictorSPX getFollow() {
        return follow;
    }
   
    public void setPercentOutput(double output) {
        master.set(ControlMode.PercentOutput, output);
    }
    
    public static Wrist getInstance() {
        if (instance == null) {
            instance = new Wrist();
        }
        return instance;
    }
}
