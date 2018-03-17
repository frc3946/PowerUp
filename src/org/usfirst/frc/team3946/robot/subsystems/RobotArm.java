package org.usfirst.frc.team3946.robot.subsystems;

import org.usfirst.frc.team3946.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

/**
 *
 */
public class RobotArm extends PIDSubsystem {

	final double switchPos = 317;
	final double cubePos = 362.5;
	final double scalePos = 136;
	
	WPI_TalonSRX armTalon = new WPI_TalonSRX(RobotMap.armTalon);
	AnalogInput armPot = new AnalogInput(1);
	
    // Initialize your subsystem here
    public RobotArm() {				
    	super("RobotArm", 2.0, 0, 0);
    	setAbsoluteTolerance(0.05);
    	getPIDController().setContinuous(false);
        // Use these to get going:
        // setSetpoint() -  Sets where the PID controller should move the system
        //                  to
        // enable() - Enables the PID controller.
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

    protected double returnPIDInput() {
        // Return your input value for the PID loop
        // e.g. a sensor, like a potentiometer:
        // yourPot.getAverageVoltage() / kYourMaxVoltage;
    	double averageVoltage;
    	double actualVoltage;
    	averageVoltage = armPot.getAverageVoltage();
        actualVoltage = averageVoltage / 12;
    	return actualVoltage;
    }

    protected void usePIDOutput(double output) {
        // Use output to drive your system, like a motor
        // e.g. yourMotor.set(output);
    	armTalon.pidWrite(output);
    }
    
    public void switchPosition() {
    	setSetpoint(switchPos);
    	enable();
    }
    
    public void scalePosition() {
    	setSetpoint(scalePos);
    	enable();
    }
    
    public void cubePosition() {
    	setSetpoint(cubePos);
    	enable();
    }
    
    public void armRest() {
    	armTalon.set(0);
    }
}
