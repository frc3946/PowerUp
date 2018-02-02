package org.usfirst.frc.team3946.robot.subsystems;

import org.usfirst.frc.team3946.robot.RobotMap;
import org.usfirst.frc.team3946.robot.commands.TankDrive;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

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
	
	DifferentialDrive robotDrive = new DifferentialDrive(frontLeft, frontRight);
	
	public DriveTrain() {
	}
	   
	public void tankDrive(double speedLeft, double speedRight){
	
		leftSpeed = frontLeft.getMotorOutputPercent();
		rightSpeed = frontRight.getMotorOutputPercent();
		actualSpeed = (leftSpeed + rightSpeed) / 2;

		SmartDashboard.putNumber("MotorOutputPercent", actualSpeed);
		SmartDashboard.putNumber("Right Motor Output Percent", leftSpeed); 
		SmartDashboard.putNumber("Left Motor Output Percent", rightSpeed); 

		
//		backLeft.follow(frontLeft);
//		backRight.follow(frontRight);
				
		robotDrive.tankDrive(-speedLeft, -speedRight);
	}
	
    public void initDefaultCommand() {

    	setDefaultCommand(new TankDrive()); 
   
    } 
     
}

