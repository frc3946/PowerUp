package org.usfirst.frc.team3946.robot.commands;

import org.usfirst.frc.team3946.robot.Robot;
import org.usfirst.frc.team3946.robot.subsystems.Arm;
import org.usfirst.frc.team3946.robot.subsystems.RobotArm;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ArmMotorOff extends Command {

    public ArmMotorOff() {
    	requires(Robot.robotArm);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	RobotArm.armTalon.set(0);
//    	if(Robot.arm.potRate() > 0) {
//    		Arm.armTalon.set(.54);
//    	} else {   
//    		Arm.armTalon.set(0);
//    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
