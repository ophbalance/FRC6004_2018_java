package frc.robot.subsystems;

import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Victor;
import frc.robot.commands.*;

/**
 *
 */
public class Lift extends Subsystem {
    
    // Motor Controllers
	Victor liftDrive = null;
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        // Define the motor and set it to zero
       liftDrive = new Victor(RobotMap.LIFT_VICTOR);
       setDefaultCommand(new LiftCommand());
    }
    
    public void update(double liftSpeed) {
        // Update motor speed to passed in value
       liftDrive.set(liftSpeed);
    }

    public void up(double liftSpeed) {
        // Drive lift upwords at passed in static power
       liftDrive.set(liftSpeed);
    }

    public void down(double liftSpeed) {
        // Drive lift downwards at passed in static power
       liftDrive.set(-liftSpeed);
    }

   
}