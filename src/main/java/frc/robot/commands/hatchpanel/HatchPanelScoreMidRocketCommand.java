/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.hatchpanel;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.Calibrations;
import frc.robot.commands.arm.ArmMoveToHeightCommand;
import frc.robot.commands.beak.BeakReleaseHatchPanelCommand;
import frc.robot.commands.drivetrain.DriveTrainDriveInchesCommand;
import frc.robot.commands.drivetrain.DriveTrainDriveTargetCommand;
import frc.robot.commands.elevator.ElevatorMoveToHeightCommand;

public class HatchPanelScoreMidRocketCommand extends CommandGroup {
  
  public HatchPanelScoreMidRocketCommand() {
    addParallel(new DriveTrainDriveTargetCommand(Calibrations.distanceDesiredFromRocket));
    addParallel(new ElevatorMoveToHeightCommand(Calibrations.elevatorMidHatchEncoderValue));
    addSequential(new ArmMoveToHeightCommand(Calibrations.armMidHatchEncoderValue));
    addSequential(new BeakReleaseHatchPanelCommand());
    addParallel(new ElevatorMoveToHeightCommand(Calibrations.elevatorLowHatchEncoderValue));
    addParallel(new ArmMoveToHeightCommand(Calibrations.armLowHatchEncoderValue));
    addSequential(new DriveTrainDriveInchesCommand(24, .6, Calibrations.drivingBackward));
  }
}
