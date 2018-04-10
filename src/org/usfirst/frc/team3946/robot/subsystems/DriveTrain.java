package org.usfirst.frc.team3946.robot.subsystems;

import org.usfirst.frc.team3946.robot.Robot;
import org.usfirst.frc.team3946.robot.RobotMap;
import org.usfirst.frc.team3946.robot.commands.DoubleJoyArcade;
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
	public double leftRate, rightRate;
	public double ticks = 19.099; // 360 / (wheel diameter * 3.14)
	public double actualLeftRate, actualRightRate;
	
	public static WPI_TalonSRX frontLeft = new WPI_TalonSRX(RobotMap.frontLeftMotor);
	public static WPI_TalonSRX frontRight = new WPI_TalonSRX(RobotMap.frontRightMotor);
	public static VictorSPX backLeft = new VictorSPX(RobotMap.backLeftMotor);
	public static VictorSPX backRight = new VictorSPX(RobotMap.backRightMotor);	
	
	DifferentialDrive robotDrive = new DifferentialDrive(frontLeft, frontRight);
	   

		public void autoDrive(double autoLeft, double autoRight) {
		backLeft.follow(frontLeft);
		backRight.follow(frontRight);
		
		robotDrive.tankDrive(autoLeft, autoRight);
	}
	
	public void tankDrive(double speedLeft, double speedRight){
			
		backLeft.follow(frontLeft);
		backRight.follow(frontRight);
				
		robotDrive.tankDrive(-speedLeft, -speedRight);
	}
	
	public void singleJoyArcadeDrive(double forward, double turn) { //for the "SingleJoyArcade" command
		
		backLeft.follow(frontLeft);
		backRight.follow(frontRight);
		
		frontLeft.setSensorPhase(false);
		frontRight.setSensorPhase(true);
		
		frontLeft.setInverted(true);
		frontRight.setInverted(false);
		
		forward = -(Robot.m_oi.driverController.getY(GenericHID.Hand.kLeft));
    	turn = Robot.m_oi.driverController.getX(GenericHID.Hand.kLeft);
    	
    	
    	robotDrive.arcadeDrive(forward, turn);
		
	}
	
	public void doubleJoyArcadeDrive(double forward, double turn){ //for the "DoubleJoyArcade" Command
		
		backLeft.follow(frontLeft);
		backRight.follow(frontRight);
		
		frontLeft.setInverted(false);
		frontRight.setInverted(false);
		
		forward = (Robot.m_oi.driverController.getY(GenericHID.Hand.kLeft));
		turn = Robot.m_oi.driverController.getX(GenericHID.Hand.kRight);
		
		robotDrive.arcadeDrive(-forward, -turn);
		
	}
	
    public void initDefaultCommand() {

    	setDefaultCommand(new DoubleJoyArcade()); 
   
    } 
 
    public void encoders() {
    	frontLeft.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 10);
    	frontRight.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 10);
    	//not sure what to do after this \_(>_>)_/
    	frontLeft.setSensorPhase(false);
    	frontRight.setSensorPhase(false);
    }
    
    public double leftEncRate() {
    	leftRate = frontLeft.getSelectedSensorPosition(0);    
    	actualLeftRate = leftRate/ticks;
    	SmartDashboard.putNumber("Left Encoder", actualLeftRate);
    	return leftRate;
    }
    
    public double rightEncRate() {
    	rightRate = frontRight.getSelectedSensorPosition(0);
    	actualRightRate = rightRate/ticks;
    	return rightRate;
    }
    
    public double getSpeed() {
    	leftSpeed = DriveTrain.frontLeft.getSelectedSensorVelocity(0);
		rightSpeed = DriveTrain.frontRight.getSelectedSensorVelocity(0);
		actualSpeed = (leftSpeed + rightSpeed) / 2;	
		return actualSpeed;
    }
    
    public double currentfrontLeftOut() {
    	double lfCurrent;
    	lfCurrent = frontLeft.getOutputCurrent();
    	return lfCurrent;
    }
    
    public double currentfrontRightOut() {
    	double lrCurrent;
    	lrCurrent = frontRight.getOutputCurrent();
    	return lrCurrent;
    }
    
    
    public double currentBackRightOut() {
    	double brCurrent;
    	brCurrent = backRight.getOutputCurrent();
    	return brCurrent;
    }
    
    public double currentBackLeftOut() {
    	double blCurrent;
    	blCurrent = backLeft.getOutputCurrent();
    	return blCurrent;
    }
    
}

