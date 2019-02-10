package frc.robot.commands.commandgroups;

import frc.robot.commands.arm.ArmExtendFullyCommand;
import frc.robot.commands.elevator.ElevatorRetractFullyCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class LowerElevatorThenExtendArmCommandGroup extends CommandGroup {

    public LowerElevatorThenExtendArmCommandGroup() {
        addSequential(new ElevatorRetractFullyCommand());
        addSequential(new ArmExtendFullyCommand());
    }
}
