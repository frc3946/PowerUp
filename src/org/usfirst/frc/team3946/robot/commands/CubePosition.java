package org.usfirst.frc.team3946.robot.commands;

import org.usfirst.frc.team3946.robot.Robot;
import org.usfirst.frc.team3946.robot.subsystems.Arm;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class CubePosition extends Command {

    public CubePosition() {
    	requires(Robot.arm);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
<<<<<<< HEAD:src/org/usfirst/frc/team3946/robot/commands/RaiseArm.java
=======
    	
    	while(Robot.arm.potRate() < 10) {
    		Arm.armTalon.set(0.5);
    	} 
    	
>>>>>>> 5bf54a19dc996153999bd46b41d80a35409922d2:src/org/usfirst/frc/team3946/robot/commands/CubePosition.java
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
<<<<<<< HEAD:src/org/usfirst/frc/team3946/robot/commands/RaiseArm.java
=======
    	Arm.armTalon.set(0);
>>>>>>> 5bf54a19dc996153999bd46b41d80a35409922d2:src/org/usfirst/frc/team3946/robot/commands/CubePosition.java
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
