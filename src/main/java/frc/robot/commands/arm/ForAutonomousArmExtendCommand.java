package frc.robot.commands.arm;

import frc.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ForAutonomousArmExtendCommand extends Command {
    double magnitude;

    public ForAutonomousArmExtendCommand(double magnitude) {
        requires(Robot.ARM_SUBSYSTEM);
        this.magnitude = magnitude;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {

        //Robot.ARM_SUBSYSTEM.extend(magnitude); WAS USED BEFORE

        // System.out.println("EXTENDING ARM.EXTENDING ARM.EXTENDING ARM.EXTENDING
        // ARM.EXTENDING ARM.EXTENDING ARM.EXTENDING ARM.EXTENDING ARM.");
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
        Robot.ARM_SUBSYSTEM.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
