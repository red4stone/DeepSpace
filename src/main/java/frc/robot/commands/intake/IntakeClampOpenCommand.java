package frc.robot.commands.intake;

import frc.robot.subsystems.IntakeClampSubsystem;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class IntakeClampOpenCommand extends Command {
	IntakeClampSubsystem intakeClampSubsystem;
	
    public IntakeClampOpenCommand(IntakeClampSubsystem IntakeClampSubsystem) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(IntakeClampSubsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	intakeClampSubsystem.open();
    }

    // Make this return true when this Command no longer needs to run execute()
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