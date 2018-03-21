package org.usfirst.frc.team3946.robot.subsystems;

import org.usfirst.frc.team3946.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

/**
 *
 */
public class RobotArm extends PIDSubsystem {

	final double switchPos = 10; //574
	final double cubePos = 25; //811
	final double scalePos = 50; //154
	double analogPosition;
	double analogVelocity;
	int selectedSensorPos = armTalon.getSelectedSensorPosition(0);
	int selectedSensorVel = armTalon.getSelectedSensorVelocity(0);
	
	public static WPI_TalonSRX armTalon = new WPI_TalonSRX(RobotMap.armTalon);
//	AnalogPotentiometer armPot = new AnalogPotentiometer(1, 360, 0);
	
    // Initialize your subsystem here
    public RobotArm() {				
    	super("RobotArm", 2.0, 0, 0);
    	setAbsoluteTolerance(0.05);
    	getPIDController().setContinuous(false);
        // Use these to get going:
        // setSetpoint() -  Sets where the PID controller should move the system
        //                  to
        // enable() - Enables the PID controller.
    	armTalon.configSelectedFeedbackSensor(FeedbackDevice.Analog, 0, 0);
    	armTalon.setSensorPhase(true);
    	armTalon.configOpenloopRamp(0.5, 0);
    	armTalon.configClosedloopRamp(0, 0);
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

    protected double returnPIDInput() {
        // Return your input value for the PID loop
        // e.g. a sensor, like a potentiometer:
        // yourPot.getAverageVoltage() / kYourMaxVoltage;
    	return 0;
    }

    protected void usePIDOutput(double output) {
        // Use output to drive your system, like a motor
        // e.g. yourMotor.set(output);
    	armTalon.pidWrite(output);
    }
    
	public double analogPos() {
		analogPosition = armTalon.getSensorCollection().getAnalogIn();
		return analogPosition;
	}

	public double analogVel() {
		analogVelocity = armTalon.getSensorCollection().getAnalogInVel();
		return analogVelocity;
	}
    
	
	
}
