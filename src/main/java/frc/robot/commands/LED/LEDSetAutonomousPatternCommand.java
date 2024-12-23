package frc.robot.commands.LED;

import frc.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class LEDSetAutonomousPatternCommand extends Command {

    public LEDSetAutonomousPatternCommand() {
        requires(Robot.LED_SUBSYSTEM);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        Robot.LED_SUBSYSTEM.setAutonomousPattern();
    }

    @Override
    protected boolean isFinished() {
        
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }

}
