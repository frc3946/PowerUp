package org.usfirst.frc.team3946.robot.subsystems;

import org.usfirst.frc.team3946.robot.Robot;
import org.usfirst.frc.team3946.robot.RobotMap;

import edu.wpi.first.wpilibj.PWM;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Intake extends Subsystem {
	
	public Talon leftIntakeMotor = new Talon(RobotMap.leftIntakeMotor);
	public Talon rightIntakeMotor = new Talon(RobotMap.rightIntakeMotor);
	public Servo leftIntakeServo = new Servo(0);
//	public Servo rightIntakeServo = new Servo(2);
	
	double leftAngle = 0;
	double rightAngle = 0;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	public double leftServoAngle() {
	    leftAngle = leftIntakeServo.get();	//gets left servo angle
		return leftAngle;
	}
	
//	public double rightServoAngle() {
//		rightAngle = rightIntakeServo.get();	//gets right servo angle
//		return rightAngle;
//	}
	
//	public void servoSpeed() {
//		leftIntakeServo.set(0.5);	//sets both of the servo speeds
//		rightIntakeServo.set(0.5); 
//	}
	
//	public void servoComeback() {
//		leftIntakeServo.setAngle(0);	//has the servo come back to
//		rightIntakeServo.setAngle(180);
//	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

