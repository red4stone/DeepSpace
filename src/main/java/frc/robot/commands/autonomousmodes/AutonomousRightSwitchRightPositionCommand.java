package frc.robot.commands.autonomousmodes;

import frc.robot.AutonomousCalibrations;
import frc.robot.Calibrations;
import frc.robot.Robot;
import frc.robot.commands.arm.ArmExtendFullyCommand;
import frc.robot.commands.drivetrain.DriveTrainDriveInchesCommand;
import frc.robot.commands.drivetrain.DriveTrainStopCommand;
import frc.robot.commands.drivetrain.DriveTrainTurnRelativeDegreesCommand;
import frc.robot.commands.elevator.ElevatorMoveToHeightCommand;
import frc.robot.commands.cargointake.CargoWheelsSpitCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutonomousRightSwitchRightPositionCommand extends CommandGroup {

	public AutonomousRightSwitchRightPositionCommand() {

		addSequential(new DriveTrainDriveInchesCommand(AutonomousCalibrations.StraightSwitchDriveForwardFromWallInches,
				AutonomousCalibrations.AutonomousScoreSwitchDriveForwardPowerMagnitude, Calibrations.drivingForward,
				AutonomousCalibrations.SideSwitchDriveForwardFromWallTimeoutSeconds));
		addSequential(new DriveTrainTurnRelativeDegreesCommand(Robot.DRIVE_TRAIN_SUBSYSTEM, -90));
		addSequential(new DriveTrainDriveInchesCommand(AutonomousCalibrations.StraightSwitchDriveForwardToSwitchInches,
				AutonomousCalibrations.AutonomousScoreSwitchDriveForwardPowerMagnitude, Calibrations.drivingForward));

		addSequential(new DriveTrainStopCommand());

		addSequential(new ElevatorMoveToHeightCommand(Calibrations.elevatorCargoShipPortEncoderValue));
		addSequential(new ArmExtendFullyCommand());
		addSequential(new CargoWheelsSpitCommand(AutonomousCalibrations.AutonomousScoreSwitchCargoPushPowerMagnitude));
	}

}
