/*----------------------------------------------------------------------------*/

/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team3946.robot;

import org.usfirst.frc.team3946.robot.commands.ClimberExtend;
import org.usfirst.frc.team3946.robot.commands.ClimberRetract;
import org.usfirst.frc.team3946.robot.commands.IntakeArmGrab;
import org.usfirst.frc.team3946.robot.commands.IntakeArmOut;
import org.usfirst.frc.team3946.robot.commands.CubeIntakeWheelIn;
import org.usfirst.frc.team3946.robot.commands.CubeIntakeWheelOut;
import org.usfirst.frc.team3946.robot.commands.CubeToSwitchCG;
import org.usfirst.frc.team3946.robot.commands.ArmCubePos;
import org.usfirst.frc.team3946.robot.commands.DoubleJoyArcade;
import org.usfirst.frc.team3946.robot.commands.ClawClose;
import org.usfirst.frc.team3946.robot.commands.IntakeArmPrepPos;
import org.usfirst.frc.team3946.robot.commands.ClawOpen;
import org.usfirst.frc.team3946.robot.commands.ClimbMotorOff;
import org.usfirst.frc.team3946.robot.commands.ArmMotorOff;
import org.usfirst.frc.team3946.robot.commands.ArmScalePos;
import org.usfirst.frc.team3946.robot.commands.SingleJoyArcade;
import org.usfirst.frc.team3946.robot.commands.ArmSwitchPos;
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
	
	Button normalTank = new JoystickButton(manipulatorController, 12);
	Button singleJoyArcade = new JoystickButton(manipulatorController, 17);
	Button doubleJoyArcade = new JoystickButton(manipulatorController, 18);
	
	//Buttons on Manipulator's Controller...
	
//	Button openIntake = new JoystickButton(manipulatorController, 1);
//	Button closeIntake = new JoystickButton(manipulatorController, 2);
//	Button switchPosition = new  JoystickButton(manipulatorController, 1);
//	Button scalePosition = new JoystickButton(manipulatorController, 4);
	Button cubeIn = new JoystickButton(manipulatorController, 5);
	Button cubeOut = new JoystickButton(manipulatorController, 6);
	Button openClamp = new JoystickButton(manipulatorController, 7);
	Button closeClamp = new JoystickButton(manipulatorController, 8);
//	Button cubePosition = new JoystickButton(manipulatorController, 2);
	Button restPosition = new JoystickButton(manipulatorController, 4);

	//Buttons on Manipulator's Joystick...
	
//	Button climbMotorOff = new JoystickButton(manipulatorJoystick, 1);
	Button cubeToSwitch = new JoystickButton(manipulatorController, 1);
	Button cubePositionJoy = new JoystickButton(manipulatorController, 4);
	Button restPositionJoy = new JoystickButton(manipulatorJoystick, 5);
	Button openClampJoy = new JoystickButton(manipulatorJoystick, 6);
	Button closeClampJoy = new JoystickButton(manipulatorJoystick, 7);
	Button cubeInJoy = new JoystickButton(manipulatorJoystick, 8);
	Button cubeOutJoy = new JoystickButton(manipulatorJoystick, 9);
//	Button climbUp = new JoystickButton(manipulatorJoystick, 10);
//	Button climbDown = new JoystickButton(manipulatorJoystick, 11);
//	Button armPrepJoy = new JoystickButton(manipulatorJoystick, 1);
//	Button switchPositionJoy = new  JoystickButton(manipulatorJoystick, 4);
//	Button scalePositionJoy = new JoystickButton(manipulatorJoystick, 5);
//	Button armInJoy = new JoystickButton(manipulatorJoystick, 10);
//	Button armOutJoy = new JoystickButton(manipulatorJoystick, 11);

	
	public OI() {		
		
		/*
		 * Commands for Switching Drive and Manipulating the Robot...
		 */
		
		singleJoyArcade.whenPressed(new SingleJoyArcade());
		doubleJoyArcade.whenPressed(new DoubleJoyArcade());
		normalTank.whenPressed(new TankDrive());
		cubeOut.whileHeld(new CubeIntakeWheelOut());
		cubeIn.whileHeld(new CubeIntakeWheelIn());	
//		cubePosition.whenPressed(new CubePosition());
//		switchPosition.whenPressed(new SwitchPosition());
//		scalePosition.whenPressed(new ArmScalePos());
		restPosition.whenPressed(new ArmMotorOff());
		openClamp.whenPressed(new ClawOpen());
		closeClamp.whenPressed(new ClawClose());
//		openIntake.whenPressed(new IntakeArmPrepPos());
//		closeIntake.whenPressed(new IntakeArmGrab());
		
		cubeOutJoy.whileHeld(new CubeIntakeWheelOut());
		cubeInJoy.whileHeld(new CubeIntakeWheelIn());	
		cubePositionJoy.whileHeld(new ArmCubePos());
//		switchPositionJoy.whileHeld(new ArmSwitchPos());
//		scalePositionJoy.whenPressed(new ArmScalePos());
		restPositionJoy.whenPressed(new ArmMotorOff());
		openClampJoy.whenPressed(new ClawClose());
		closeClampJoy.whenPressed(new ClawOpen());
//		armOutJoy.whenPressed(new IntakeArmOut());
//		armInJoy.whenPressed(new IntakeArmGrab());
//		armPrepJoy.whenPressed(new IntakeArmPrepPos());
		cubeToSwitch.whenPressed(new CubeToSwitchCG());
//		climbUp.whileHeld(new ClimberExtend());
//		climbDown.whileHeld(new ClimberRetract());
//		climbMotorOff.whenPressed(new ClimbMotorOff());
	}
}
