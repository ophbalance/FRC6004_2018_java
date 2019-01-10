package frc.robot.subsystems;

import frc.robot.RobotMap;
import frc.robot.commands.DriveTank;


import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Drivetrain extends Subsystem {
	
	// Motor Controllers
	Victor leftFrontDrive = null;
	Victor leftRearDrive = null;
	Victor rightFrontDrive = null;
	Victor rightRearDrive = null;
	
	// Robot Drive
	DifferentialDrive robotDrive = null;
	//RobotDrive robotDrive = null;
	
	public Drivetrain() {
		// Victors
		leftFrontDrive = new Victor(RobotMap.DRIVETRAIN_LEFT_FRONT_VICTOR);
		leftRearDrive = new Victor(RobotMap.DRIVETRAIN_LEFT_BACK_VICTOR);
		SpeedControllerGroup m_left = new SpeedControllerGroup(leftFrontDrive, leftRearDrive);
		
		rightFrontDrive = new Victor(RobotMap.DRIVETRAIN_RIGHT_FRONT_VICTOR);
		rightRearDrive = new Victor(RobotMap.DRIVETRAIN_RIGHT_BACK_VICTOR);
		SpeedControllerGroup m_right = new SpeedControllerGroup(rightFrontDrive, rightRearDrive);

		
		// Robot Drive
		robotDrive = new DifferentialDrive(m_left, m_right);
	}
	
	public void tankDrive(double leftSpeed, double rightSpeed) {
		//robotDrive.arcadeDrive(moveSpeed, rotateSpeed);
		robotDrive.tankDrive(leftSpeed, -rightSpeed);
	}

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new DriveTank());
    }
    
   
}