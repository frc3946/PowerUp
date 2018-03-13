package org.usfirst.frc.team3946.robot.commands;

import org.usfirst.frc.team3946.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ClosedIntakeArm extends Command {

    public ClosedIntakeArm() {
    	requires(Robot.intake);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }
    double startR = 0, startL = 1, endR = 150, endL = 30;

    // Called just before this Command runs the first time
    protected void initialize() {
//    	Robot.intake.leftIntakeServo.setDisabled();
//    	Robot.intake.rightIntakeServo.setAngle(startR);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.intake.leftIntakeServo.setAngle(60);
    	Robot.intake.rightIntakeServo.setAngle(120);
//    	Robot.intake.rightIntakeServo.setSpeed(.5);
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
