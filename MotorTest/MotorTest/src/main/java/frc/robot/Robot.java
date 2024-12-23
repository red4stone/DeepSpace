/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 * This is a demo program showing the use of the RobotDrive class, specifically
 * it contains the code necessary to operate a robot with tank drive.
 */
public class Robot extends TimedRobot {
  private DifferentialDrive m_myRobot;
  private Joystick m_joystick;
  Talon TalonLeft = new Talon(0); 
  Talon TalonRight = new Talon(1);
  

  @Override
  public void robotInit() {

    // m_myRobot = new DifferentialDrive(TalonLeft, TalonRight);
    m_joystick = new Joystick(0);
    
  }

  @Override
  public void teleopPeriodic() {
    //m_myRobot.tankDrive(m_joystick.getRawAxis(1), m_joystick.getRawAxis(3));
    TalonLeft.set(m_joystick.getRawAxis(1) * -1);
    TalonRight.set(m_joystick.getRawAxis(3));
  }
}
