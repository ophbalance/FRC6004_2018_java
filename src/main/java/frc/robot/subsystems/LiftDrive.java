/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import frc.robot.RobotMap;
import frc.robot.commands.DriveLift;
import edu.wpi.first.wpilibj.Spark;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class LiftDrive extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  // Motor Controllers
  Spark liftDriveMotor_l = null;
  Spark liftDriveMotor_r = null;
  
  public LiftDrive() {
    // Victors
    liftDriveMotor_l = new Spark(RobotMap.LIFT_VICTOR_LEFT);
    liftDriveMotor_r = new Spark(RobotMap.LIFT_VICTOR_RIGHT);

  }
  
  public void LiftMove(double liftSpeed) {
    //robotDrive.arcadeDrive(moveSpeed, rotateSpeed);
    liftDriveMotor_l.set(liftSpeed);
    liftDriveMotor_r.set(-liftSpeed);
  }
  
 
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new DriveLift());
  }
}
