package frc.robot;

import frc.controls.AxisCode;
import frc.controls.ButtonCode;

public class ControlsMap {
	// Drive controller
	public static final ButtonCode driveShiftToLowGearButton = ButtonCode.LEFTBUMPER;
	public static final ButtonCode driveShiftToHighGearButton = ButtonCode.RIGHTBUMPER;
	public static final AxisCode driveCutPowerAxis = AxisCode.RIGHTTRIGGER;
	public static final AxisCode operatorOverrideAxis = AxisCode.LEFTTRIGGER;
	
	/*
	
	// Button pad
	// Operation controller
	public static final int fuelCargoCollectButton = 6;
	public static final int fuelCargoReverseButton = 7;
	public static final int fuelPumpPumpButton = 3;
	public static final int fuelPumpReverseButton = 4;
	public static final int shooterRevButton = 5;
	public static final int shooterShootButton = 5;
	// public static final int shooterStopButton = 4;
	// public static final int shooterOverrideShootButton = 5;
	public static final int gearCargoExtendButton = 4;
	// public static final int gearCargoRetractButton = 5;
	public static final int gearCarriageExtendButton = 2;
	public static final int gearCarriageRetractButton = 1;
	public static final int climberClimbButton = 3;
	*/
	
	// Xbox controller
	
	// Operation controller
	public static final int fuelCargoCollectButton = 1;
	public static final int fuelCargoReverseButton = 2;
	public static final int fuelPumpPumpButton = 3;
	public static final int fuelPumpReverseButton = 4;
	public static final int shooterRevButton = 9;
	public static final int shooterShootButton = 9;
	// public static final int shooterStopButton = 4;
	// public static final int shooterOverrideShootButton = 5;
	public static final int gearCargoExtendButton = 6;
	// public static final int gearCargoRetractButton = 5;
	public static final AxisCode elevatorExtendButton = AxisCode.LEFTSTICKY;
	public static final AxisCode elevatorRetractButton = AxisCode.LEFTSTICKY;
	public static final int climberClimbButton = 10;
	
	
	
	public static final ButtonCode operationShiftToLowGearButton = ButtonCode.LEFTBUMPER;
	public static final int operationFlashlightAimAxis = 4;
	
	// Custom buttons
	
	public static final int fuelPumpOverrideShooterIsSpinningButton = 11;
	public static final int climberOverrideStallProtectionButton = 12;
	public static final int climberOverrideClimberDirectionButton = 13;
	public static final int gearCarriageOverrideExtensionLimitButton = 2;
	public static final int gearCarriageOverrideRetractionLimitButton = 1;
	public static final int shooterOverrideShootButton = 16;
	
	// buttonPanel
	public static final int redLight = 1;
	public static final int greenLight = 2;
	public static final int blueLight = 3;
	public static final int whiteLight = 4;
	
}
