/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team3946.robot;

import org.usfirst.frc.team3946.robot.commands.CubeIn;
import org.usfirst.frc.team3946.robot.commands.CubeOut;
import org.usfirst.frc.team3946.robot.commands.CubePosition;
import org.usfirst.frc.team3946.robot.commands.DoubleJoyArcade;
import org.usfirst.frc.team3946.robot.commands.Grab;
import org.usfirst.frc.team3946.robot.commands.Release;
import org.usfirst.frc.team3946.robot.commands.RestPosition;
import org.usfirst.frc.team3946.robot.commands.ScalePosition;
import org.usfirst.frc.team3946.robot.commands.SingleJoyArcade;
import org.usfirst.frc.team3946.robot.commands.SwitchPosition;
import org.usfirst.frc.team3946.robot.commands.TankDrive;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import libraries.XboxControllers;

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

	Button normalTank = new JoystickButton(manipulatorController, 4);
	Button singleJoyArcade = new JoystickButton(manipulatorController, 7);
	Button doubleJoyArcade = new JoystickButton(manipulatorController, 8);
	
	//Buttons on Manipulator's Controller...
	
	Button cubePosition = new JoystickButton(manipulatorController, 1);
	Button restPosition = new JoystickButton(manipulatorController, 2);
	Button switchPosition = new  JoystickButton(manipulatorController, 3);
	Button scalePosition = new JoystickButton(manipulatorController, 4);
	Button cubeIn = new JoystickButton(manipulatorController, 5);
	Button cubeOut = new JoystickButton(manipulatorController, 6);
	Button toggleClaw = new JoystickButton(manipulatorController, 7);
	
	public OI() {		
		
		/*
		 * Commands for Switching Drive and Manipulating the Robot...
		 */
		
		singleJoyArcade.whenPressed(new SingleJoyArcade());
		doubleJoyArcade.whenPressed(new DoubleJoyArcade());
		normalTank.whenPressed(new TankDrive());
		cubeOut.whileHeld(new CubeOut());
		cubeIn.whileHeld(new CubeIn());	
		toggleClaw.toggleWhenPressed(new Grab());
		cubePosition.whileHeld(new CubePosition());
		switchPosition.whileHeld(new SwitchPosition());
		scalePosition.whileHeld(new ScalePosition());
		restPosition.whenPressed(new RestPosition());
		
	}
}
