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

public class AutonomousLeftSwitchMiddlePositionCommand extends CommandGroup{
	
	public AutonomousLeftSwitchMiddlePositionCommand() {
		addSequential(new DriveTrainDriveInchesCommand(AutonomousCalibrations.AutonomousScoreSwitchMiddlePositionDriveForwardFirstSegmentInches,
				AutonomousCalibrations.AutonomousScoreSwitchDriveForwardPowerMagnitude,
    			Calibrations.drivingForward));
		addSequential(new DriveTrainTurnRelativeDegreesCommand(Robot.DRIVE_TRAIN_SUBSYSTEM, -90, AutonomousCalibrations.SwitchGyroScaleFactor, 1.5));
		addSequential(new DriveTrainDriveInchesCommand(AutonomousCalibrations.AutonomousScoreSwitchMiddlePositionLateralDriveForwardInches - AutonomousCalibrations.ExchangeZoneBufferMiddlePositionLeftSwitch,
				AutonomousCalibrations.AutonomousScoreSwitchDriveForwardPowerMagnitude,
    			Calibrations.drivingForward));
		addSequential(new DriveTrainTurnRelativeDegreesCommand(Robot.DRIVE_TRAIN_SUBSYSTEM, 90, AutonomousCalibrations.SwitchGyroScaleFactor, 1.5));
		addSequential(new DriveTrainDriveInchesCommand(AutonomousCalibrations.AutonomousScoreSwitchMiddlePositionDriveForwardSecondSegmentInches,
				AutonomousCalibrations.AutonomousScoreSwitchDriveForwardPowerMagnitude,
    			Calibrations.drivingForward,
    			2.5));

		addSequential(new DriveTrainStopCommand());
		// addSequential(new DriveTrainTurnRelativeDegreesCommand(Robot.DRIVE_TRAIN_SUBSYSTEM, 90));
		
		addSequential(new ElevatorMoveToHeightCommand(Calibrations.elevatorMidHatchEncoderValue));
		addSequential(new ArmExtendFullyCommand());
		addSequential(new CargoWheelsSpitCommand(AutonomousCalibrations.AutonomousScoreSwitchCargoPushPowerMagnitude));
	}

}
