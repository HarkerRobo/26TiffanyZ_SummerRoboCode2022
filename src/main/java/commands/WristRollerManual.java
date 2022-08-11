package commands;

import frc.robot.OI;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.WristRoller;
import harkerrobolib.commands.IndefiniteCommand;

public class WristRollerManual extends IndefiniteCommand {
    public WristRollerManual() {
        addRequirements(WristRoller.getInstance());
    }
    public void execute() {
        double output = OI.getInstance().getDriver().getLeftTrigger();
        if (Intake.getInstance().getIntaking()) {
            output = 0.3;
        }
        else if (OI.getInstance().getDriver().getLeftTrigger() > 0.5) {
            output = -0.3;
        }
        else {
            output = 0.1;
        }
        WristRoller.getInstance().setPercentOutput(output);
    }
    public void end(boolean interrupted) {
        WristRoller.getInstance().setPercentOutput(0);
    }
}
