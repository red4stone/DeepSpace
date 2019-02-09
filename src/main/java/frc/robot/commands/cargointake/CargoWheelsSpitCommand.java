package frc.robot.commands.cargointake;

import frc.robot.Calibrations;
import frc.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class CargoWheelsSpitCommand extends Command{
	double magnitude;
	Timer durationTimer;

	public CargoWheelsSpitCommand(double magnitude) {
		requires(Robot.CARGO_WHEEL_SUBSYSTEM);
		// TODO Auto-generated constructor stub
		this.magnitude = magnitude;
		this.durationTimer = new Timer();
		this.durationTimer.start();
	}
	// Called just before this Command runs the first time
    protected void initialize() {
    	this.durationTimer.reset();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	// Robot.CARGO_WHEEL_SUBSYSTEM.push(magnitude);
    	Robot.CARGO_WHEEL_SUBSYSTEM.push(this.magnitude);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	boolean isFinished = false;
    	
    	if (durationTimer.get() > Calibrations.cargoSpitTimer) {
    		isFinished = true;
    	}
    	
        return isFinished;
    }

    // Called once after isFinished returns true
    protected void end() {
    	// Robot.CARGO_WHEEL_SUBSYSTEM.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}

