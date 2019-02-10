package frc.robot.subsystems;

import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Calibrations;
import frc.robot.commands.drivetrain.DriveTrainDriveInchesCommand;
import frc.robot.commands.drivetrain.DriveTrainStopCommand;
import frc.util.PCDashboardDiagnostics;

/**
 *
 */
public class LimelightSubsystem extends Subsystem {
	static double Limit = 0.00;
	static double A = 0;
	static double B = 0;
	static double C = 0;
	static double D = 0;
	edu.wpi.first.networktables.NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
	NetworkTableEntry tx = table.getEntry("tx");
	NetworkTableEntry ty = table.getEntry("ty");
	NetworkTableEntry ta = table.getEntry("ta");
	NetworkTableEntry tv = table.getEntry("tv");
	NetworkTableEntry ledMode = table.getEntry("ledMode");

	private double _heightDifference = Calibrations.FLOOR_TO_TARGET_CENTER_HEIGHT - Calibrations.FLOOR_TO_LIMELIGHT_LENS_HEIGHT;
	private double _angleToTargetFromHorizontal = Math.tan(Math.toRadians(Calibrations.CAMERA_ANGLE_OFFSET_FROM_HORIZONTAL + ty.getDouble(0.0)));
	public double inchesToTarget = _heightDifference/_angleToTargetFromHorizontal;
	private double _powerMagnitude = 0.0;
  	private double _distanceDesiredFromTarget = 0.0;
  	private double _distanceToDrive = 0.0;
	private int _direction = 0;
	private Timer _safetyTimer;
  	double timeoutSeconds = Calibrations.DriveTrainDriveInchesSafetyTimerSeconds;
  	DriveTrainDriveInchesCommand driveTrainDriveInchesCommand = new DriveTrainDriveInchesCommand(this._distanceToDrive, this._powerMagnitude, this._direction);

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());

	}

	public void periodic() {
		PCDashboardDiagnostics.SubsystemNumber("Limelight", "TargetArea", this.getTargetArea());
		PCDashboardDiagnostics.SubsystemNumber("Limelight", "angleOffHorizontal", this.angleOffHorizontal());
		PCDashboardDiagnostics.SubsystemNumber("Limelight", "angleOffVertical", this.angleOffVertical());
        PCDashboardDiagnostics.SubsystemBoolean("Limelight", "hasTarget", this.hasTarget());
		table.getEntry("ledMode").setNumber(1);
		PCDashboardDiagnostics.AdHocNumber("Vision Tracking Distance (Inches)", (_heightDifference / _angleToTargetFromHorizontal));
		PCDashboardDiagnostics.AdHocNumber("Height Difference", _heightDifference);
		PCDashboardDiagnostics.AdHocNumber("Angle From Crosshair to Target", _angleToTargetFromHorizontal);
	}

	public double getTargetArea() {
		return ta.getDouble(0);
	}

	public boolean hasTarget() {
		boolean hasTarget;
		if (tv.getDouble(0) == 1) {
			hasTarget = true;
		} else {
			hasTarget = false;
		}
		return hasTarget;
	}

	public double angleOffHorizontal() {
		return tx.getDouble(0);
	}

	public double angleOffVertical() {
		return ty.getDouble(0);
	}

	public static void limeLightDiagnostics() {

	}

	public static void limeLightDetect() {

		// if( A*B^(targetArea+C) +D < Limit) {

		// }
	}

	public void DriveToTarget(double distanceDesiredFromTarget) {
		this._distanceDesiredFromTarget = distanceDesiredFromTarget;

		if (inchesToTarget > (this._distanceDesiredFromTarget + 18)) {
			this._distanceToDrive = this.inchesToTarget - this._distanceDesiredFromTarget;
			this._powerMagnitude = 0.6;
			this._direction = Calibrations.drivingForward;
			this.driveTrainDriveInchesCommand.start();
			System.out.println("MOVE FORWARD " + this._distanceToDrive + " INCHES");

		} else if (inchesToTarget < (this._distanceDesiredFromTarget - 18)) {
			this._distanceToDrive = this._distanceDesiredFromTarget - this.inchesToTarget;
			this._powerMagnitude = 0.6;
			this._direction = Calibrations.drivingForward;
			this.driveTrainDriveInchesCommand.start();
			System.out.println("BACKING UP " + this._distanceToDrive + " INCHES");

		} else if (this.hasTarget() == false) {
			(new DriveTrainStopCommand()).start();

		} else {
			(new DriveTrainStopCommand()).start();
			System.out.println("DO NOTHING, I'M AT 10 FEET");
		} 
	}

	

		/*Robot.DRIVE_TRAIN_SUBSYSTEM.ravenTank.setGyroTargetHeading(Robot.DRIVE_TRAIN_SUBSYSTEM.ravenTank.getCurrentHeading() + x);
        
		if (inchesToTarget < Calibrations.MINIMUM_DISTANCE_FROM_LIMELIGHT) {
			inchesToTarget = Calibrations.MINIMUM_DISTANCE_FROM_LIMELIGHT;
		}

		if (inchesToTarget > Calibrations.MAXIMUM_DISTANCE_FROM_LIMELIGHT) {
			inchesToTarget = Calibrations.MAXIMUM_DISTANCE_FROM_LIMELIGHT;
		}
		
		if (hasTarget()) {
			if (inchesToTarget < (distanceDesiredFromTarget + Calibrations.desiredTargetBuffer) && inchesToTarget > (distanceDesiredFromTarget - Calibrations.desiredTargetBuffer)) {
				(new DriveTrainDriveFPSCommand()).start();
				System.out.println("DO NOTHING, I'M AT 2 FEET");
			} else if (inchesToTarget > distanceDesiredFromTarget) {
				DriveTrainDriveInchesCommand nick = new DriveTrainDriveInchesCommand(inchesToTarget - distanceDesiredFromTarget, .2, Calibrations.drivingForward);
				nick.start();
				System.out.println("MOVE FORWARD " + (inchesToTarget - distanceDesiredFromTarget) + " INCHES");
			} else if (inchesToTarget < distanceDesiredFromTarget) {
				DriveTrainDriveInchesCommand nick = new DriveTrainDriveInchesCommand(distanceDesiredFromTarget - inchesToTarget, .2, Calibrations.drivingBackward);
				nick.start();
				System.out.println("BACKING UP " + (distanceDesiredFromTarget - inchesToTarget) + " INCHES");
			} 
		} else {
			
		*/

		/*driveTrainDriveInchesCommand.start();
    	
    	if (direction == Calibrations.drivingBackward) {
    	netInchesTraveledSoFar = distanceToDriveBlind - Robot.DRIVE_TRAIN_SUBSYSTEM.ravenTank.getNetInchesTraveled();
    	} else {
    	netInchesTraveledSoFar = Robot.DRIVE_TRAIN_SUBSYSTEM.ravenTank.getNetInchesTraveled() - distanceToDriveBlind;
		   }*/
		   
		   /*  boolean hasTraveledTargetDistance = (netInchesTraveledSoFar >= distanceToDriveBlind); 
    	double area = ta.getDouble(0.0);
        
   	 	if (timeoutTimer.get() > timeoutSeconds) {
      	hasTraveledTargetDistance = true;

      	System.out.println("TIMEOUTTIMEOUTTIMEOUT");
    	}		

    	if (area > 0.0) {
      	new DriveDistanceToTargetCommand().start();
      	hasTraveledTargetDistance = true;
    	}
    	
    	return hasTraveledTargetDistance; */
}
