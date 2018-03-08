package org.usfirst.frc.team3946.robot.subsystems;

import org.usfirst.frc.team3946.robot.Robot;
import org.usfirst.frc.team3946.robot.RobotMap;
import org.usfirst.frc.team3946.robot.commands.IntakeStop;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Intake extends Subsystem {
	
	public Talon intakeMotor = new Talon(RobotMap.intakeMotor);
	public Servo leftIntakeServo = new Servo(0);
	public Servo rightIntakeServo = new Servo(2);
	
	double leftAngle = 0;
	double rightAngle = 0;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	public double leftServoAngle() {
		return leftAngle = leftIntakeServo.get();
	}
	
	public double rightServoAngle() {
		rightAngle = rightIntakeServo.get();
		return rightAngle;
	}
	
	public void servoSpeed() {
		leftIntakeServo.set(0.5);
		rightIntakeServo.set(0.5); //boi am i dum
	}
	
	public void servoComeback() {
		leftIntakeServo.set(-0.5);
		rightIntakeServo.set(-0.5); // boi am i dum
	}
	
	public void setIntakeSpeed(double speed) {
		Robot.intake.intakeMotor.set(speed);
	}
	
	public void intakeStop(double speed) {
		Robot.intake.intakeMotor.set(0);
	}
	
	public void intakeEnable() {
		leftIntakeServo.setAngle(75);
		rightIntakeServo.setAngle(75);
	}
	
	public void intakeDisable() {
		leftIntakeServo.setAngle(0);
		rightIntakeServo.setAngle(0);
	}
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new IntakeStop());
    }
}

