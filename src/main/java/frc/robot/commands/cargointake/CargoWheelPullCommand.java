package frc.robot.commands.cargointake;

import frc.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class CargoWheelPullCommand extends Command {

    public CargoWheelPullCommand () {
         requires(Robot.CARGO_WHEEL_SUBSYSTEM); 
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	if(Robot.CARGO_WHEEL_SUBSYSTEM.hasCube() == false) {
    		// new LowerElevatorThenExtendArmCommandGroup().start();
    	}
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.CARGO_WHEEL_SUBSYSTEM.pull();
    	System.out.println("CargoWheelSubsystem.pull();CargoWheelSubsystem.pull();CargoWheelSubsystem.pull();CargoWheelSubsystem.pull();CargoWheelSubsystem.pull();CargoWheelSubsystem.pull();CargoWheelSubsystem.pull();CargoWheelSubsystem.pull();CargoWheelSubsystem.pull();CargoWheelSubsystem.pull();CargoWheelSubsystem.pull();CargoWheelSubsystem.pull();");
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	// Robot.CARGO_WHEEL_SUBSYSTEM.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.CARGO_WHEEL_SUBSYSTEM.stop();
    }
}
