/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

public class Calibrations2019 {

    // DRIVE TRAIN
	// Slew rate of .2 seems to work well for when the lift is lowered, though more testing
	// is necessary - might turn it up or down slightly for increased performance.
	// public static final double slewRate = .2;
	public static final double slewRateMinimum = .3;
	public static final double slewRateMaximum = .35;
	
	// The safe slew rate changes based upon a few variables:
	// 		- What gear we are in
	//		- How high the lift is
	//		- What direction the robot is moving (forward or backward.)
	//			(backwards to forwards seems worse - but that's with no arm or cube, and a broken chassis)
	//		- A number low enough to be safe for all scenarios will negatively impact normal operation.
	
	public static final double cutPowerModeMovementRatio = .3;
	public static final double cutPowerModeTurnRatio = .5;
	//public static final double gyroAdjustmentScaleFactor = .011; // Could possibly cause gyro issues
	public static final double gyroAdjustmentDefaultScaleFactor = .03;
	public static final double driveTrainTurnRelativeDegreesGyroAdjustmentScaleFactor = .009;
	public static final double gyroCooldownTimerTime = .5;
	public static final double translationMaxTurnScaling = .5;
	public static final double gyroAutoTurnAcceptableErrorDegrees = 1;
	public static final boolean driveTrainStartingIsInHighGear = false;
	
	// Drive collision
	public static final double DriveTrainCollisionJerkThreshold = 4;

	// 2019 and newer robots use talonSRX instead talon
	public static final Boolean UseTalonSRXForDriveController = true;

	
	// Drive and gyro modes
	public static final int bulldozerTank = 0;
	public static final int fpsTank = 1;
	
	public static final int gyroDisabled = 0;
	public static final int gyroEnabled = 1;
	
	// Any turn taking too long to complete (e.g. wheel scrub has halted the turn) will abandon after this number of seconds.
	public static final double DriveTrainTurnRelativeDegreesSafetyTimerSeconds = 1;
	public static final double DriveTrainDriveInchesSafetyTimerSeconds = 3;
	
	// Deadband
	public static final double deadbandMagnitude = .1;
	
	// Default drive and gyro modes
	public static final int defaultDriveMode = Calibrations.fpsTank;
	public static final int defaultGyroMode = Calibrations.gyroEnabled;
	
	//public static final int defaultGyroMode = Calibrations.gyroDisabled;
	
	
	// DRIVE ENCODERS
	// The *3 is for low gear. In high gear, it would just be 4096. Run all autonomous modes in low gear.
	public static final int encoderCUI103CyclesPerRevolution = 4096 * 3;
	// public static final int encoderE4TCyclesPerRevolution = 360;
	// public static final int encoderE4PCyclesPerRevolution = 250;
	public static final double driveWheelDiameterInches = 6;
	public static final double driveWheelCircumferenceInches = Calibrations.driveWheelDiameterInches * Math.PI;
	//public static final double driveEncoderE4TCyclesPerInch = (double) Calibrations.encoderE4TCyclesPerRevolution / Calibrations.driveWheelCircumferenceInches;
	//public static final double driveEncoderE4PCyclesPerInch = (double) Calibrations.encoderE4PCyclesPerRevolution / Calibrations.driveWheelCircumferenceInches;
	
	// We're using CUI 103 encoders on both sides of the drivetrain.
	public static final int leftEncoderCyclesPerRevolution = Calibrations.encoderCUI103CyclesPerRevolution;
	public static final int rightEncoderCyclesPerRevolution = Calibrations.encoderCUI103CyclesPerRevolution;
	
	// Direction magic numbers
	public static final int drivingForward = -1;
	public static final int drivingBackward = 1;
	
	// Adjust max power based on elevator height
	public static final double DRIVETRAIN_MAXPOWER_AT_MAX_ELEVEATOR_HEIGHT = .4;
    

    //ELEVATOR
    public static final double kP = 12.0;
    public static final double kI = 0.0;
    public static final double kD = 170.0;

    public static final double elevatorHoldPositionPowerMagnitude = -.075;
	
	public static final int elevatorEncoderMinimumValue = 0;
    public static final int elevatorEncoderMaximumValue = 27000;

    public static final int elevatorLowHatchEncoderValue = 4000;
    public static final int elevatorMidHatchEncoderValue = 18000;
    public static final int elevatorHighHatchEncoderValue = 24000;

    public static final int elevatorCargoShipPortEncoderValue = 24000;
    public static final int elevatorLowRocketPortEncoderValue = 24000;
    public static final int elevatorMidRocketPortEncoderValue = 24000;
    public static final int elevatorHighRocketPortEncoderValue = 24000;

    // The safety margin is how far away from the end of travel the encoders will stop the lift.
	// At low speeds (max of .3), and a lift max value of 30k, 1500 maxes out the elevator.
	// At higher speeds, a higher value is needed because the elevator will overshoot the target until we have PID.
	
	public static final int elevatorLiftUpwardSafetyMargin = 1300;
	public static final int elevatorLiftDownwardSafetyMargin = 700;
	public static final int ELEVATOR_AT_POSITION_BUFFER = 500;
	
	public static final double elevatorConsideredMovingEncoderRate = 0;
	
    public static final double ELEVATOR_MOVE_TO_POSITION_TIMEOUT = 2;
    public static final double ELEVATOR_SAFETY_TIMER_TIMEOUT = 3.5;
	
	public static final int elevatorInchesToEncoderTicksConversionValue = 411;
    public static final int elevatorInchesToEncoderTicksOffsetValue = 10;
	

    //ARM
}
