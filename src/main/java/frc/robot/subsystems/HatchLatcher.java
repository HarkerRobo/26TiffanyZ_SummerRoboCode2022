package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class HatchLatcher extends SubsystemBase {
    private static HatchLatcher instance;

    private DoubleSolenoid flower;
    private DoubleSolenoid extender;
    private static final int flowerRev = 0;
    private static final int flowerFor = 0;
    private static final int extenderRev = 0;
    private static final int extenderFor = 0;

    private HatchLatcher() {
        flower = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, flowerRev, flowerFor);
        extender = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, extenderRev, extenderFor);
    }
    public static HatchLatcher getInstance() {
        if (instance == null) {
            instance = new HatchLatcher();
        }
        return instance;
    }

    public void toggleFlower() {
        if (flower.get() == DoubleSolenoid.Value.kOff) {
            flower.set(DoubleSolenoid.Value.kReverse);
        }
        else if (flower.get() == DoubleSolenoid.Value.kReverse) {
            flower.set(DoubleSolenoid.Value.kForward);
        }
        else if (flower.get() == DoubleSolenoid.Value.kForward) {
            flower.set(DoubleSolenoid.Value.kReverse);
        }
    }

    public void toggleExtender() {
        if (extender.get() == DoubleSolenoid.Value.kOff) {
            extender.set(DoubleSolenoid.Value.kReverse);
        }
        else if (extender.get() == DoubleSolenoid.Value.kReverse) {
            extender.set(DoubleSolenoid.Value.kForward);
        }
        else if (extender.get() == DoubleSolenoid.Value.kForward) {
            extender.set(DoubleSolenoid.Value.kReverse);
        }
    }
}
