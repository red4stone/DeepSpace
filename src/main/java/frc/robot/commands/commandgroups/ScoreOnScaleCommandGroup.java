package frc.robot.commands.commandgroups;

import frc.robot.AutonomousCalibrations;
import frc.robot.Calibrations;
import frc.robot.commands.arm.ArmExtendToHighScaleCommand;
import frc.robot.commands.arm.ArmMoveToHeightCommand;
import frc.robot.commands.arm.ArmRetractFullyCommand;
import frc.robot.commands.elevator.ElevatorExtendFullyCommand;
import frc.robot.commands.elevator.ElevatorMoveToHeightCommand;
import frc.robot.commands.elevator.ElevatorRetractFullyCommand;
import frc.robot.commands.intake.IntakeWheelStopCommand;
import frc.robot.commands.intake.IntakeWheelsSpitCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class ScoreOnScaleCommandGroup extends CommandGroup {

    public ScoreOnScaleCommandGroup() {
    	//addSequential(new ElevatorMoveToHeightCommand(Calibrations.elevatorMidwayEncoderValue));
    	addSequential(new ElevatorExtendFullyCommand());
    	
    	
    	addSequential(new ArmExtendToHighScaleCommand());
    	// addSequential(new ElevatorExtendFullyCommand());
    	
    	addSequential(new IntakeWheelsSpitCommand(AutonomousCalibrations.AutonomousScaleIntakeSpitPowerMagnitude));
    	addSequential(new IntakeWheelStopCommand());
    	
    	addSequential(new ArmRetractFullyCommand());
    	addSequential(new ElevatorRetractFullyCommand());
    	
    }
}
