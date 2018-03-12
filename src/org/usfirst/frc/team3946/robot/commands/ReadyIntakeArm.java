package org.usfirst.frc.team3946.robot.commands;

import org.usfirst.frc.team3946.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ReadyIntakeArm extends Command {
	
	double startR = 0, startL = 1, endR = .3, endL = .7;

    public ReadyIntakeArm() {
    	requires(Robot.intake);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.intake.leftIntakeServo.set(startL);
//    	Robot.intake.rightIntakeServo.set(startR);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.intake.leftIntakeServo.set(endL);
//    	Robot.intake.rightIntakeServo.set(endR);
    	Robot.intake.leftIntakeServo.setSpeed(.5);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
