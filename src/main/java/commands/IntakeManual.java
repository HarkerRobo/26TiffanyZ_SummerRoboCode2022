package commands;

import frc.robot.OI;
import frc.robot.subsystems.Intake;
import harkerrobolib.commands.IndefiniteCommand;

public class IntakeManual extends IndefiniteCommand{
    public IntakeManual() {
        addRequirements(Intake.getInstance());
    }
    public void execute() {
        double output = OI.getInstance().getDriver().getRightTrigger();
        if (output > 0.5) {
            output = 0.3;
        }
        else {
            output = 0;
        }
        Intake.getInstance().setPercentOutput(output);
    }
    public void end(boolean interrupted) {
        Intake.getInstance().setPercentOutput(0);
    }
}
