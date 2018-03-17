/*----------------------------------------------------------------------------*/
 	 	/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team3946.robot;

import org.usfirst.frc.team3946.robot.commands.JoystickTankDrive;
import org.usfirst.frc.team3946.robot.commands.LeftSwitchAutonomous;
import org.usfirst.frc.team3946.robot.commands.ReadyIntakeArm;
import org.usfirst.frc.team3946.robot.commands.RightSwitchAutonomous;
import org.usfirst.frc.team3946.robot.commands.SingleJoyArcade;
import org.usfirst.frc.team3946.robot.commands.DoubleJoyArcade;
import org.usfirst.frc.team3946.robot.commands.TankDrive;
import org.usfirst.frc.team3946.robot.subsystems.Arm;
import org.usfirst.frc.team3946.robot.subsystems.Claw;
import org.usfirst.frc.team3946.robot.subsystems.Climb;
import org.usfirst.frc.team3946.robot.subsystems.DriveTrain;
import org.usfirst.frc.team3946.robot.subsystems.Intake;
import org.usfirst.frc.team3946.robot.subsystems.LED;
import org.usfirst.frc.team3946.robot.subsystems.RobotArm;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.DriverStation.Alliance;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 */
public class Robot extends TimedRobot {
		
	public static final DriveTrain drivetrain = new DriveTrain();
	public static final Intake intake = new Intake();
	public static final Claw claw = new Claw();
	public static final Arm arm = new Arm();
	public static final Climb climb = new Climb();
	public static final LED led = new LED();
	public static final RobotArm robotArm = new RobotArm();
	
	public static OI m_oi; 

	Command m_autonomousCommand;
	SendableChooser<Command> m_chooser = new SendableChooser<>();
	Command teleop;
	
	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override				
	public void robotInit() {	

		Alliance team;
		String gameData;
		gameData = DriverStation.getInstance().getGameSpecificMessage();
		team = DriverStation.getInstance().getAlliance();
		
		m_autonomousCommand = new LeftSwitchAutonomous();
		
		if(team == DriverStation.Alliance.Blue) {
			if(gameData.length() > 0) {
				if(gameData.charAt(0) == 'L') {
					m_autonomousCommand = new LeftSwitchAutonomous();
				} else {
					m_autonomousCommand = new RightSwitchAutonomous();
				}
			} 
		} else if(team == DriverStation.Alliance.Red){
			if(gameData.length() > 0) {
				if(gameData.charAt(0) == 'R') {
					m_autonomousCommand = new RightSwitchAutonomous();
				} else {
					m_autonomousCommand = new LeftSwitchAutonomous();
				}
			}
		}
		
//		if(gameData.length() > 0) {
//			if(gameData.charAt(0) == 'L') {
//				m_autonomousCommand = new LeftSwitchAutonomous();
//			} else {
//				m_autonomousCommand = new RightSwitchAutonomous();
//			}
//		}
//	
//		if(gameData.length() > 0) {
//			if(gameData.charAt(1) == 'L') {
//				m_autonomousCommand = new LeftScaleAutonomous();
//			} else {
//				m_autonomousCommand = new RightScaleAutonomous();
//			}
			
//		}
		
		 m_chooser.addDefault("Left Auto Switch", new LeftSwitchAutonomous());
		 m_chooser.addObject("Right Auto Switch", new RightSwitchAutonomous());
		
		UsbCamera frontCam = CameraServer.getInstance().startAutomaticCapture(RobotMap.frontCam);
		
		frontCam.setFPS(60);
		frontCam.setResolution(640, 640);
		
		m_oi = new OI();
		
		// chooser.addObject("My Auto", new MyAutoCommand());
		SmartDashboard.putData("Auto mode", m_chooser);
		SmartDashboard.putData("Joystick Tank Drive", new JoystickTankDrive()); 
		SmartDashboard.putData("Xbox Tank Drive", new TankDrive());
		SmartDashboard.putData("One Joystick Arcade Drive", new SingleJoyArcade());
		SmartDashboard.putData("Two Joystick Arcade Drive", new DoubleJoyArcade());	
		SmartDashboard.putData("Left SWITCH Auto", new LeftSwitchAutonomous());
		SmartDashboard.putData("Right SWITCH Auto", new RightSwitchAutonomous());
		
		
//		Robot.intake.leftIntakeServo.set(0);
//		Robot.intake.rightIntakeServo.set(1);
//		SmartDashboard.putNumber("Right Intake Servo",7);
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * <p>You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {

		/*
		 * String autoSelected = SmartDashboard.getString("Auto Selector",
		 * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
		 * = new MyAutoCommand(); break; case "Default Auto": default:
		 * autonomousCommand = new ExampleCommand(); break; }
		 */
		
		m_autonomousCommand = new LeftSwitchAutonomous();
		
		// schedule the autonomous command (example)
		if (m_autonomousCommand != null) {
			m_autonomousCommand.start();
		}
	}

	/**
	 * This function is called periodically during autonomous.
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
		
		
	}

	@Override
	public void teleopInit() {		
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
//		teleop = new ReadyIntakeArm();
		if (m_autonomousCommand != null) {
			m_autonomousCommand.cancel();		
		}
	}

	/**
	 * This function is called periodically during operator control.
	 */
	@Override
	public void teleopPeriodic() {
				
		Scheduler.getInstance().run();
		
		SmartDashboard.putNumber("Arm Potentiometer", robotArm.potRate());
//		SmartDashboard.putNumber("Climb Encoder Rate", climb.climbRate());
		SmartDashboard.getNumber("Left Encoder Rate", drivetrain.leftEncRate());
		SmartDashboard.getNumber("Right Encoder Rate", drivetrain.rightEncRate());
		SmartDashboard.getNumber("Robot Speed", drivetrain.getSpeed());
//		SmartDashboard.putNumber("Left Intake Servo", Robot.intake.leftIntakeServo.get());
//		SmartDashboard.putNumber("Right Intake Servo", Robot.intake.rightServoAngle());
//		SmartDashboard.updateValues();

	}

	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void testPeriodic() {
	}		
		
}