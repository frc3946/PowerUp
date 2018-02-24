package org.usfirst.frc.team3946.robot.subsystems;

import org.usfirst.frc.team3946.robot.RobotMap;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Climb extends Subsystem {

	public static AnalogPotentiometer climbPot;
	public static Talon climbTalon;
	
	double rate;
	
	public Climb() {
		climbPot = new AnalogPotentiometer(RobotMap.climbPot, 360, 0);
		climbTalon = new Talon(RobotMap.climbTalon);
	}
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	public double climbRate() {
		rate = Climb.climbPot.get();
	
		return rate;
	}
	
	public void climbSpeed() {
		climbTalon.set(0.5);
	}
	
	public void climbStop() {
		climbTalon.set(0);
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

