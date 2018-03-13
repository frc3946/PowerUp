package org.usfirst.frc.team3946.robot.commands;

import org.usfirst.frc.team3946.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoStraight extends Command {

	double went;
	
    public AutoStraight() {
    	requires(Robot.drivetrain);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	setTimeout(1);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	this.went = Robot.drivetrain.leftEncRate();
    			
    	if (this.went < 275) {
    		Robot.drivetrain.autoDrive(0.4, 0.4);
    	}
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return this.went > 275 || isTimedOut();
    }
    
    // Called once after isFinished returns true
    protected void end() {
    	Robot.drivetrain.autoDrive(0, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
