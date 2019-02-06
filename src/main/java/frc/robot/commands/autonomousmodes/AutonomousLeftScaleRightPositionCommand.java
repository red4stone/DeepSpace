package frc.robot.commands.autonomousmodes;

import frc.robot.AutonomousCalibrations;
import frc.robot.Calibrations;
import frc.robot.Robot;
import frc.robot.commands.commandgroups.ScoreOnScaleCommandGroup;
import frc.robot.commands.drivetrain.DriveTrainDriveInchesCommand;
import frc.robot.commands.drivetrain.DriveTrainTurnRelativeDegreesCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutonomousLeftScaleRightPositionCommand extends CommandGroup {
    public AutonomousLeftScaleRightPositionCommand() {
    	addSequential(new DriveTrainDriveInchesCommand(AutonomousCalibrations.AutonomousOppositeSideScaleForwardMovementtInches,
    			AutonomousCalibrations.AutonomousDriveScaleDriveForwardPowerMagniude,
    			Calibrations.drivingForward,
    			7));
    	addSequential(new DriveTrainTurnRelativeDegreesCommand(Robot.DRIVE_TRAIN_SUBSYSTEM, -90, Calibrations.driveTrainTurnRelativeDegreesGyroAdjustmentScaleFactor, 1.7));
    	addSequential(new DriveTrainDriveInchesCommand(AutonomousCalibrations.AutonomousOppositeSideScaleLateralMovementInches,
    			AutonomousCalibrations.AutonomousDriveScaleDriveForwardPowerMagniude,
    			Calibrations.drivingForward,
    			8));
    	addSequential(new DriveTrainTurnRelativeDegreesCommand(Robot.DRIVE_TRAIN_SUBSYSTEM, 90, Calibrations.driveTrainTurnRelativeDegreesGyroAdjustmentScaleFactor, 1.7));
    	
    	addSequential(new DriveTrainDriveInchesCommand(AutonomousCalibrations.AutonomousOppositeSideScaleMoveIntoNullZoneInches,
    			AutonomousCalibrations.AutonomousDriveScaleDriveForwardPowerMagniude,
    			Calibrations.drivingForward));
    	addSequential(new DriveTrainTurnRelativeDegreesCommand(Robot.DRIVE_TRAIN_SUBSYSTEM, 90, Calibrations.driveTrainTurnRelativeDegreesGyroAdjustmentScaleFactor, 1.7));
    	
    	addSequential(new ScoreOnScaleCommandGroup());
    }
}
