package frc.robot;

import commands.ToggleExtender;
import commands.ToggleFlower;
import harkerrobolib.wrappers.XboxGamepad;

public class OI {
    private static OI instance;
    private XboxGamepad driver;
    private static final int ID = 0;
    private OI() {
        driver = new XboxGamepad(ID);
        initBindings();
    }
    public static OI getInstance() {
        if (instance == null) {
            instance = new OI();
        }
        return instance;
    }
    public void initBindings() {
        driver.getButtonA().whenPressed(new ToggleIntake());
        driver.getButtonB().whenPressed(new ToggleFlower());
        driver.getButtonX().whenPressed(new ToggleExtender());
    }
    public XboxGamepad getDriver() {
        return driver;
    }
}