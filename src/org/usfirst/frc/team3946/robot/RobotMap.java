/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team3946.robot;

import edu.wpi.first.wpilibj.AnalogInput;//temporary

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	
	
	/*
	 * Drivetrain Motors
	 */
	public static int frontLeftMotor = 1;
	public static int frontRightMotor = 2;
	public static int backLeftMotor = 3;
	public static int backRightMotor = 4;
	
	/*
	 * Cameras
	 */
	public static int frontCam = 0;
	
	/*
	 *Intake
	 */
	public static int intakeMotor = 1;
	
	/*
	 *Claw 
	 */
	public static int clawSolenoid = 1;
	
	/*
	 * Arm
	 */
	public static int armAnalogInput = 1;
	public static int armTalon = 6;
	
	/*
	 * Controllers (OI)
	 */
	public static int leftStick = 0;
	public static int rightStick = 1;
	public static int manipulatorController = 2;
	public static int driverController = 3;
	// For example to map the left and right motors, you could define the
	// following variables to use with your drivetrain subsystem.
	// public static int leftMotor = 1;
	// public static int rightMotor = 2;

	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;
}
