package frc.robot.commands.cargowheel;

import frc.robot.subsystems.CargoWheelSubsystem;

import edu.wpi.first.wpilibj.command.Command;

public class CargoWheelSuckIdleCommand extends Command {

    CargoWheelSubsystem cargoWheelSubsystem;

    public CargoWheelSuckIdleCommand(CargoWheelSubsystem cargoWheelSubsystem) {
        requires(cargoWheelSubsystem);
        this.cargoWheelSubsystem = cargoWheelSubsystem;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        cargoWheelSubsystem.idle();
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
