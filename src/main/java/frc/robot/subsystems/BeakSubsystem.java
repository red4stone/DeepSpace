/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Solenoid;
import frc.robot.commands.beak.BeakReleaseHatchPanelCommand;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class BeakSubsystem extends Subsystem {
  Solenoid beak = new Solenoid(RobotMap.beakSolenoid);

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
      // Set the default command for a subsystem here.
      //setDefaultCommand(new MySpecialCommand());
      setDefaultCommand(new BeakReleaseHatchPanelCommand());
    }
    
    public void release() {
    	beak.set(false);
    }
    
    public void capture() {
      beak.set(true);
  }
}
