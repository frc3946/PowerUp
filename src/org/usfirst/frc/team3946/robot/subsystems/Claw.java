package org.usfirst.frc.team3946.robot.subsystems;

import org.usfirst.frc.team3946.robot.RobotMap;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Claw extends Subsystem {
	Solenoid clawSolenoid = new Solenoid(5,1);

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	public void openClaw() {
		clawSolenoid.set(true);
	}
	
	public void closeClaw() {
		clawSolenoid.set(false);
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

