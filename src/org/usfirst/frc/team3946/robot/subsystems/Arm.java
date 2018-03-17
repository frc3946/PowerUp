package org.usfirst.frc.team3946.robot.subsystems;

import org.usfirst.frc.team3946.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Arm extends Subsystem {
	
	public static AnalogPotentiometer armPot;
	public static WPI_TalonSRX armTalon;
		
	double potRates;
	double check;
	
	public Arm() {
		armTalon = new WPI_TalonSRX(RobotMap.armTalon);
		armPot = new AnalogPotentiometer(1, 360, 0);		
	}
	
	public double potRate() {
		potRates = armPot.get();
	
		return potRates;
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

}