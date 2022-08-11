package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import harkerrobolib.wrappers.HSTalon;

public class WristRoller extends SubsystemBase {
    private static WristRoller instance;

    private static final int rollerID = 0;

    //instance variable for the motor
    private HSTalon roller;

    private static final boolean rollerINV = false;

    private WristRoller() {
        roller = new HSTalon(rollerID);
        roller.setInverted(rollerINV);
    }

    public HSTalon getRoller() {
        return roller;
    }
   
    public void setPercentOutput(double output) {
        roller.set(ControlMode.PercentOutput, output);
    }
    
    public static WristRoller getInstance() {
        if (instance == null) {
            instance = new WristRoller();
        }
        return instance;
    }
}
