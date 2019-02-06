package frc.robot.commands.intake;

import frc.robot.Calibrations;
import frc.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class IntakeWheelPushHardCommand extends Command {

    public IntakeWheelPushHardCommand() {
        requires(Robot.INTAKE_WHEEL_SUBSYSTEM);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	//System.out.println("IntakeWheelSubsystem.push();IntakeWheelSubsystem.push();IntakeWheelSubsystem.push()");
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.INTAKE_WHEEL_SUBSYSTEM.push(Calibrations.IntakeSpitPowerMagnitude);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	// Robot.INTAKE_WHEEL_SUBSYSTEM.stop();
    	
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.INTAKE_WHEEL_SUBSYSTEM.stop();
    }
}