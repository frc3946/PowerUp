package org.usfirst.frc.team3946.robot.subsystems;

import org.usfirst.frc.team3946.robot.Robot;
import org.usfirst.frc.team3946.robot.RobotMap;
import org.usfirst.frc.team3946.robot.commands.TankDrive;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class DriveTrain extends Subsystem {
	
    double leftSpeed, rightSpeed;
	public double actualSpeed;

	public static WPI_TalonSRX frontLeft = new WPI_TalonSRX(RobotMap.frontLeftMotor);
	public static WPI_TalonSRX frontRight = new WPI_TalonSRX(RobotMap.frontRightMotor);
	public static WPI_TalonSRX backLeft = new WPI_TalonSRX(RobotMap.backLeftMotor);
	public static WPI_TalonSRX backRight = new WPI_TalonSRX(RobotMap.backRightMotor);
//	public static VictorSPX backLeft = new VictorSPX(RobotMap.backLeftMotor);
//	public static VictorSPX backRight = new VictorSPX(RobotMap.backRightMotor);
	
	
	
	DifferentialDrive robotDrive = new DifferentialDrive(frontLeft, frontRight);
	   
	public void tankDrive(double speedLeft, double speedRight){
			
		backLeft.follow(frontLeft);
		backRight.follow(frontRight);
				
		robotDrive.tankDrive(-speedLeft, -speedRight);
	}
	
	public void singleJoyArcadeDrive(double forward, double turn) {
		
		backLeft.follow(frontLeft);
		backRight.follow(frontRight);
		
		frontLeft.setSensorPhase(false);
		frontRight.setSensorPhase(true);
		
		frontLeft.setInverted(true);
		frontRight.setInverted(false);
		
		forward = Robot.m_oi.XboxController.getX(GenericHID.Hand.kLeft);
    	turn = Robot.m_oi.XboxController.getY(GenericHID.Hand.kLeft);
    	
    	
    	robotDrive.arcadeDrive(forward, turn);
		
	}
	
	public void doubleJoyArcadeDrive(double forward, double turn){
		
		backLeft.follow(frontLeft);
		backRight.follow(frontRight);
		
		frontLeft.setInverted(false);
		frontRight.setInverted(false);
		
		forward = -(Robot.m_oi.XboxController.getY(GenericHID.Hand.kLeft));
		turn = Robot.m_oi.XboxController.getX(GenericHID.Hand.kRight);
		
		robotDrive.arcadeDrive(forward, turn);
		
	}
	
    public void initDefaultCommand() {

    	setDefaultCommand(new TankDrive()); 
   
    } 
     
}

