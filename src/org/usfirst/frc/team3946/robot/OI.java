/*----------------------------------------------------------------------------*/

/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team3946.robot;

import org.usfirst.frc.team3946.robot.commands.Climber;
import org.usfirst.frc.team3946.robot.commands.ClosedIntakeArm;
import org.usfirst.frc.team3946.robot.commands.CubeIn;
import org.usfirst.frc.team3946.robot.commands.CubeOut;
import org.usfirst.frc.team3946.robot.commands.CubePosition;
import org.usfirst.frc.team3946.robot.commands.DoubleJoyArcade;
import org.usfirst.frc.team3946.robot.commands.Grab;
import org.usfirst.frc.team3946.robot.commands.ReadyIntakeArm;
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
	public Joystick manipulatorJoystick = new Joystick(RobotMap.manipulatorJoystick);

	//Buttons on the Driver's Controller...
	
	Button normalTank = new JoystickButton(manipulatorController, 4);
	Button singleJoyArcade = new JoystickButton(manipulatorController, 7);
	Button doubleJoyArcade = new JoystickButton(manipulatorController, 8);
	
	//Buttons on Manipulator's Controller...
	
	Button openIntake = new JoystickButton(manipulatorController, 1);
	Button closeIntake = new JoystickButton(manipulatorController, 2);
//	Button switchPosition = new  JoystickButton(manipulatorController, 3);
	Button scalePosition = new JoystickButton(manipulatorController, 4);
	Button cubeIn = new JoystickButton(manipulatorController, 5);
	Button cubeOut = new JoystickButton(manipulatorController, 6);
//	Button openClamp = new JoystickButton(manipulatorController, 7);
	Button closeClamp = new JoystickButton(manipulatorController, 8);
	Button cubePosition = new JoystickButton(manipulatorController, 3);
	Button restPosition = new JoystickButton(manipulatorController, 7);

	//Buttons on Manipulator's Joystick...
	
	Button climbJoy = new JoystickButton(manipulatorJoystick, 1);
	Button cubePositionJoy = new JoystickButton(manipulatorJoystick, 2);
	Button restPositionJoy = new JoystickButton(manipulatorJoystick, 3);
	Button switchPositionJoy = new  JoystickButton(manipulatorJoystick, 4);
	Button scalePositionJoy = new JoystickButton(manipulatorJoystick, 5);
	Button openClampJoy = new JoystickButton(manipulatorJoystick, 6);
	Button closeClampJoy = new JoystickButton(manipulatorJoystick, 7);
	Button cubeInJoy = new JoystickButton(manipulatorJoystick, 8);
	Button cubeOutJoy = new JoystickButton(manipulatorJoystick, 9);
	Button armOutJoy = new JoystickButton(manipulatorJoystick, 10);
	Button armInJoy = new JoystickButton(manipulatorJoystick, 11);
	
	public OI() {		
		
		/*
		 * Commands for Switching Drive and Manipulating the Robot...
		 */
		
		singleJoyArcade.whenPressed(new SingleJoyArcade());
		doubleJoyArcade.whenPressed(new DoubleJoyArcade());
		normalTank.whenPressed(new TankDrive());
		cubeOut.whileHeld(new CubeOut());
		cubeIn.whileHeld(new CubeIn());	
		cubePosition.whenPressed(new CubePosition());
//		switchPosition.whenPressed(new SwitchPosition());
		scalePosition.whenPressed(new ScalePosition());
		restPosition.whenPressed(new RestPosition());
//		openClamp.whenPressed(new Grab());
		closeClamp.whenPressed(new Release());
		openIntake.whenPressed(new ReadyIntakeArm());
		closeIntake.whenPressed(new ClosedIntakeArm());
		
		cubeOutJoy.whileHeld(new CubeOut());
		cubeInJoy.whileHeld(new CubeIn());	
		cubePositionJoy.whenPressed(new CubePosition());
		switchPositionJoy.whenPressed(new SwitchPosition());
		scalePositionJoy.whenPressed(new ScalePosition());
		restPositionJoy.whenPressed(new RestPosition());
		openClampJoy.whenPressed(new Grab());
		closeClampJoy.whenPressed(new Release());
		armOutJoy.whenPressed(new ReadyIntakeArm());
		armInJoy.whenPressed(new ClosedIntakeArm());
		
	}
}
