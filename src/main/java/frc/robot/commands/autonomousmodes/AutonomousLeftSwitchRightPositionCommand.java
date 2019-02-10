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

public class AutonomousLeftSwitchRightPositionCommand extends CommandGroup {

	public AutonomousLeftSwitchRightPositionCommand() {
		double driveForwardDistance = AutonomousCalibrations.LengthBetweenDriverWallAndSwitch
				+ AutonomousCalibrations.LengthOfSwitch + AutonomousCalibrations.LengthOfRobotBuffer;
		addSequential(new DriveTrainDriveInchesCommand(driveForwardDistance,
				AutonomousCalibrations.AutonomousScoreSwitchDriveForwardPowerMagnitude, Calibrations.drivingForward));
		addSequential(new DriveTrainTurnRelativeDegreesCommand(Robot.DRIVE_TRAIN_SUBSYSTEM, 90));
		addSequential(new DriveTrainDriveInchesCommand(AutonomousCalibrations.WidthOfSwitch,
				AutonomousCalibrations.AutonomousScoreSwitchDriveForwardPowerMagnitude, Calibrations.drivingForward));
		addSequential(new DriveTrainTurnRelativeDegreesCommand(Robot.DRIVE_TRAIN_SUBSYSTEM, 90));
		addSequential(new DriveTrainDriveInchesCommand(AutonomousCalibrations.LengthOfRobotBuffer,
				AutonomousCalibrations.AutonomousScoreSwitchDriveForwardPowerMagnitude, Calibrations.drivingForward));

		addSequential(new DriveTrainStopCommand());
		// addSequential(new
		// DriveTrainTurnRelativeDegreesCommand(Robot.DRIVE_TRAIN_SUBSYSTEM, 90));
		addSequential(new ElevatorMoveToHeightCommand(Calibrations.elevatorMidHatchEncoderValue));
		addSequential(new ArmExtendFullyCommand());
		addSequential(new CargoWheelsSpitCommand(AutonomousCalibrations.AutonomousScoreSwitchCargoPushPowerMagnitude));
	}

}
