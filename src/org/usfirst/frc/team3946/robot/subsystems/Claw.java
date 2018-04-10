package org.usfirst.frc.team3946.robot.subsystems;

import org.usfirst.frc.team3946.robot.RobotMap;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Claw extends Subsystem {

	boolean on = true;
	boolean off = false;
	
	public Solenoid clawSolenoid = new Solenoid(RobotMap.clawSolenoid);

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

//	public void openClaw() {
//		clawSolenoid.set(on);
//	}
//	
//	public void closeClaw() {
//		clawSolenoid.set(off);
//	}
	
    public void initDefaultCommand() {
    	clawSolenoid.set(off);
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

