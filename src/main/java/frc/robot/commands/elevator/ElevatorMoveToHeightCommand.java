package frc.robot.commands.elevator;

import frc.robot.Calibrations;
import frc.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ElevatorMoveToHeightCommand extends Command {
    int _targetEncoderPosition;

    public ElevatorMoveToHeightCommand(int encoderPosition) {
        requires(Robot.ELEVATOR_SUBSYSTEM);
        this._targetEncoderPosition = encoderPosition;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        Robot.ELEVATOR_SUBSYSTEM.resetSafetyTimer();
        Robot.ELEVATOR_SUBSYSTEM.startSafetyTimer();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        Robot.ELEVATOR_SUBSYSTEM.setMotorsPID(this._targetEncoderPosition);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        boolean isFinished = false;

        if (Robot.ELEVATOR_SUBSYSTEM.getSafetyTimer() > Calibrations.ELEVATOR_MOVE_TO_POSITION_TIMEOUT) {
            isFinished = true;
        }

        if (Robot.ELEVATOR_SUBSYSTEM.getIsAtPosition(_targetEncoderPosition)) {
            isFinished = true;
        }

        return isFinished;
    }

    // Called once after isFinished returns true
    protected void end() {
        Robot.ELEVATOR_SUBSYSTEM.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
