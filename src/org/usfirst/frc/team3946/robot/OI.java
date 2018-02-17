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
import org.usfirst.frc.team3946.robot.commands.SingleJoyArcade;
import org.usfirst.frc.team3946.robot.commands.TankDrive;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	public Joystick leftStick = new Joystick(0);
	public Joystick rightStick = new Joystick(1);
	public XboxController XboxController = new XboxController(2);
	
	//// TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:

	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());

	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());

	Button singleJoyArcade = new JoystickButton(XboxController, 7);
	Button doubleJoyArcade = new JoystickButton(XboxController, 8);
	Button normalTank = new JoystickButton(XboxController, 4);
	Button cubeOut = new JoystickButton(XboxController, 9);
	Button cubeIn = new JoystickButton(XboxController, 10);
	
	public OI() {		
		singleJoyArcade.whenPressed(new SingleJoyArcade());
		doubleJoyArcade.whenPressed(new DoubleJoyArcade());
		normalTank.whenPressed(new TankDrive());
		cubeOut.whileHeld(new CubeOut());
		cubeIn.whileHeld(new CubeIn());
		
	}
}
