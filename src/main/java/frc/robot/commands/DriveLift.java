/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;

/**
 * An example command.  You can replace me with your own command.
 */
public class DriveLift extends Command {
  public DriveLift() {
    // Use requires() here to declare subsystem dependencies
    requires(Robot.liftdrive);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    double liftSpeed = deadband(Robot.m_oi.opController.getRawAxis(RobotMap.OP_JOYSTICK_LEFT_RIGHT_AXIS),.1); 
    Robot.liftdrive.LiftMove(liftSpeed);
  }

  // curve inputs
  public double deadband(double JoystickValue, double DeadbandCutOff) {
    double deadbandreturn = 0;
    if (JoystickValue<DeadbandCutOff&&JoystickValue>(DeadbandCutOff*(-1))) {
        deadbandreturn = 0 ;
    }
    else {
        deadbandreturn = (JoystickValue-(Math.abs(JoystickValue)/JoystickValue*DeadbandCutOff))/(1-DeadbandCutOff);
    }
    return deadbandreturn;
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.liftdrive.LiftMove(0);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
      end();
  }
}
