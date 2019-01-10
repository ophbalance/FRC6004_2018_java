/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import frc.robot.RobotMap;
import frc.robot.commands.Extractor;
import edu.wpi.first.wpilibj.Spark;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class Extract extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  // Motor Controllers
  Spark extractmotor = null;
  
  public Extract() {
    // Victors
    extractmotor = new Spark(RobotMap.INTAKER);

  }
  
  public void extractMove(double extractSpeed) {
    //robotDrive.arcadeDrive(moveSpeed, rotateSpeed);
    extractmotor.set(extractSpeed);
  }
  
 
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new Extractor());
  }
}
