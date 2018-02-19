/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team3946.robot;

import org.usfirst.frc.team3946.robot.commands.CubeIn;
import org.usfirst.frc.team3946.robot.commands.CubeOut;
import org.usfirst.frc.team3946.robot.commands.DoubleJoyArcade;
import org.usfirst.frc.team3946.robot.commands.Grab;
import org.usfirst.frc.team3946.robot.commands.LowerArm;
import org.usfirst.frc.team3946.robot.commands.RaiseArm;
import org.usfirst.frc.team3946.robot.commands.Release;
import org.usfirst.frc.team3946.robot.commands.SingleJoyArcade;
import org.usfirst.frc.team3946.robot.commands.TankDrive;

import libraries.XboxControllers;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/*
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	/*
	 * Controllers...
	 */
	
	public Joystick leftStick = new Joystick(RobotMap.leftStick);
	public Joystick rightStick = new Joystick(RobotMap.rightStick);
	public XboxController manipulatorController = new XboxController(RobotMap.manipulatorController);
	public XboxController driverController = new XboxController(RobotMap.driverController);
	
	/* 
	 * Driver's Buttons...
	 */
	
	Button singleJoyArcade = new JoystickButton(driverController, 7);
	Button doubleJoyArcade = new JoystickButton(driverController, 8);
	Button normalTank = new JoystickButton(driverController, 4);
	
	/*
	 * Manipulator's Buttons...
	 */
	
	Button cubeIn = new JoystickButton(manipulatorController, 1);
	Button cubeOut = new JoystickButton(manipulatorController, 2);
	Button openClaw = new JoystickButton(manipulatorController, 5);
	Button closeClaw = new JoystickButton(manipulatorController, 6);
	Button raiseArm = new JoystickButton(manipulatorController, 9);
	Button lowerArm = new JoystickButton(manipulatorController, 10);
	
	public OI() {		
		
		/*
		 * Commands for Switching Drive and Manipulating the Robot...
		 */
		
		singleJoyArcade.whenPressed(new SingleJoyArcade());
		doubleJoyArcade.whenPressed(new DoubleJoyArcade());
		normalTank.whenPressed(new TankDrive());
		cubeOut.whileHeld(new CubeOut());
		cubeIn.whileHeld(new CubeIn());
		openClaw.whileHeld(new Release());
		closeClaw.whileHeld(new Grab());
		lowerArm.whileHeld(new LowerArm());
		raiseArm.whileHeld(new RaiseArm());
	}
	
}
