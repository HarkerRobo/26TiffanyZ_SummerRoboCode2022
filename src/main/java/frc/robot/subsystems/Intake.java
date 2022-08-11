package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import harkerrobolib.wrappers.HSTalon;

public class Intake extends SubsystemBase {
    private static Intake instance;
    
    private HSTalon motor;
    private static final int CANID = 0;
    private static final boolean invert = false;
    private DoubleSolenoid DS;
    private static final int DSID1 = 0;
    private static final int DSID2 = 0;
    private boolean intaking;

    
    private Intake() {
        motor = new HSTalon(CANID);
        motor.setInverted(invert);

        DS = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, DSID1, DSID2);
        intaking = false;
    }
    
    public static Intake getInstance() {
        if (instance == null) {
            instance = new Intake();
        }
        return instance;
    }
   
    public void setPercentOutput(double output) {
        motor.set(ControlMode.PercentOutput, output);
        if (output >= 0.1) {
            intaking = true;
        }
        else {
            intaking = false;
        }
    }

    public boolean getIntaking() {
        return intaking;
    }
    
    public void toggle() {
        if (DS.get() == DoubleSolenoid.Value.kOff) {
            DS.set(DoubleSolenoid.Value.kReverse);
        }
        if (DS.get() == DoubleSolenoid.Value.kReverse) {
            DS.set(DoubleSolenoid.Value.kForward);
        }
        if (DS.get() == DoubleSolenoid.Value.kForward) {
            DS.set(DoubleSolenoid.Value.kReverse);
        }
    }

    public HSTalon getCAN() {
        return motor;
    }
}
