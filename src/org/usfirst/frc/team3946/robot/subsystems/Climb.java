package org.usfirst.frc.team3946.robot.subsystems;

import org.usfirst.frc.team3946.robot.Robot;
import org.usfirst.frc.team3946.robot.RobotMap;
import org.usfirst.frc.team3946.robot.commands.Climber;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Climb extends Subsystem {

	public static WPI_TalonSRX climbTalon;
	
	double climbRates;
	
	public Climb() {
		climbTalon = new WPI_TalonSRX(RobotMap.climbTalon);
		climbTalon.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 5);
	
	}
//	
//	public double climbRate() {
//		climbRates = climbTalon.getSelectedSensorPosition(0);
//		return climbRates;
//	}
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public void climbSpeed() {
		climbTalon.set(1);
	}
	
	public void climbStop() {
		climbTalon.set(0);
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

