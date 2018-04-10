package org.usfirst.frc.team3946.robot.commands;

import org.usfirst.frc.team3946.robot.Robot;
import org.usfirst.frc.team3946.robot.RobotMap;
import org.usfirst.frc.team3946.robot.subsystems.Arm;
import org.usfirst.frc.team3946.robot.subsystems.RobotArm;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ArmScalePos extends Command {

    public ArmScalePos() {
    	requires(Robot.arm);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	Robot.robotArm.setSetpoint(RobotMap.RA_SCALE_POSITION);
    	Robot.robotArm.enable();
    	
//    	if(Robot.robotArm.analogPos() > 153) {
//    		RobotArm.armTalon.set(1);
//    	}
    	
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
    	end();
    }
}
