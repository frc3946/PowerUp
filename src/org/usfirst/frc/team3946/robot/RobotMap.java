/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team3946.robot;

public class RobotMap {
	
	//Drivetrain Motors
	public static int frontLeftMotor = 1;
	public static int frontRightMotor = 2;
	public static int backLeftMotor = 3;
	public static int backRightMotor = 4;
	
	//Cameras
	public static int frontCam = 0;

	//Intake
	public static int leftServo = 0;
	public static int rightServo = 3;
	public static int leftIntakeMotor = 1;
	public static int rightIntakeMotor = 2;
	
	//Claw 
	public static int clawSolenoid = 1;
		
	//Arm
	public static int armTalon = 6;
		
	//Controllers (OI)
	public static int leftStick = 0;
	public static int rightStick = 1;
	public static int manipulatorController = 2;
	public static int driverController = 3;
	public static int manipulatorJoystick = 4;
	
	//LEDs
	public static int redLED = 0;
	public static int greenLED = 1;
	public static int blueLED = 2;
	
	//Climb
	public static int climbEncoder = 1;
	public static int climbTalon = 7;
	
	
	//Intake arm positions
	public static final int RIGHT_OPEN_POSITION = 180;
	public static final int LEFT_OPEN_POSITION = -180;
	public static final int RIGHT_GRAB_POSITION = 65;
	public static final int LEFT_GRAB_POSITION = 80;
	public static final int RIGHT_PREP_POSITION = 90;
	public static final int LEFT_PREP_POSITION = 65;
	
	}
