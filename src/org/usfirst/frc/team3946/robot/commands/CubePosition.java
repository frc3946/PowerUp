package org.usfirst.frc.team3946.robot.commands;

import org.usfirst.frc.team3946.robot.Robot;
import org.usfirst.frc.team3946.robot.subsystems.Arm;
import org.usfirst.frc.team3946.robot.subsystems.RobotArm;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class CubePosition extends Command {

    public CubePosition() {
    	requires(Robot.robotArm);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	if(Robot.robotArm.analogPos() < 500) {
    		RobotArm.armTalon.set(.4);
       	}
    	
    	if(Robot.robotArm.analogPos() > 500) {
    		RobotArm.armTalon.set(.4);
    	}
    	
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
