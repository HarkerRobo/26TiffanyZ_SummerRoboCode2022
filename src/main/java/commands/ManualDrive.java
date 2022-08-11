package commands;

import frc.robot.OI;
import frc.robot.subsystems.Drivetrain;
import harkerrobolib.commands.IndefiniteCommand;

public class ManualDrive extends IndefiniteCommand{
    public ManualDrive() {
        addRequirements(Drivetrain.getInstance());
    }
    public void execute() {
        double speed = OI.getInstance().getDriver().getLeftX();
        double turn = OI.getInstance().getDriver().getLeftY();
        Drivetrain.getInstance().setArcadeDrive(speed, turn);
    }
    public void end(boolean interrupted) {
        Drivetrain.getInstance().setArcadeDrive(0, 0);
    }
}
