package org.usfirst.frc.team3946.robot.commands;

import org.usfirst.frc.team3946.robot.Robot;
import org.usfirst.frc.team3946.robot.RobotMap;
import org.usfirst.frc.team3946.robot.subsystems.Arm;
import org.usfirst.frc.team3946.robot.subsystems.RobotArm;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ArmCubePos extends Command {

    public ArmCubePos() {
    	requires(Robot.robotArm);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
//    	if(Robot.robotArm.analogPos() < RobotMap.RA_CUBE_POSITION) {
////        	Robot.robotArm.setSetpoint(RobotMap.RA_CUBE_POSITION);\
//    		RobotArm.armTalon.set(-0.5);
//    	} else {
//    		RobotArm.armTalon.set(0);
//    	}
//    	Robot.robotArm.enable();
//    	Robot.robotArm.armTalon.set(0);5
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    
    	RobotArm.armTalon.set(-.25);
    	
    }
    
    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.robotArm.getPIDController().onTarget();
    }

    // Called once after isFinished returns true
    protected void end() {
//    	Arm.armTalon.set(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
