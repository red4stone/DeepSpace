package frc.robot;

public class RobotMap {
	// Drive motors
	public static int leftDriveChannel = 0;
	public static int leftFollower1 = 10;
	public static int leftFollower2 = 11;
	public static int rightDriveChannel = 1;
	public static int rightFollower1 = 12;
	public static int rightFollower2 = 13;
	
	public static int armExtensionLimitSwitch = 8;
	public static int armRetractionLimitSwitch = 9;

	// Drive encoders
	public static final int leftDriveEncoder1 = 0;
	public static final int leftDriveEncoder2 = 1;
	public static final int rightDriveEncoder1 = 2;
	public static final int rightDriveEncoder2 = 3;
	
	//public static final int shiftToLowGearSolenoid = 0;
	//public static final int shiftToHighGearSolenoid = 1;
	
	//Relays 
	public static final int hasCubeLEDLightRelay = 0;
	public static final int underglowLightRelay = 1;
	
	// Elevator System
	public static final int elevatorEncoder1 = 20;
	public static final int elevatorEncoder2 = 21;
	
	public static final int elevatorMotor = 2;
	
	public static final int ExtendedLimitSwitch = 7;
	public static final int RetractionLimitSwitch = 6;
	
	// Camera
	public static final String cameraName = "cam0";
	
	// Cargo System 
	public static final int cargoMotorLeft = 5;
	public static final int cargoMotorRight = 7;
	public static final int leftCargoClampSolenoid = 2;
	public static final int rightCargoClampSolenoid = 3;

	public static final int cargoSensor = 5;
	
	// Arm System
	public static final int armMotor = 4;
	
	public static final int armHoldBackSolenoid = 6;
	
}
