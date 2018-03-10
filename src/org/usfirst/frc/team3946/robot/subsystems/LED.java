package org.usfirst.frc.team3946.robot.subsystems;

import org.usfirst.frc.team3946.robot.RobotMap;

import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.DriverStation.Alliance;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class LED extends Subsystem {

	public static DigitalOutput red = new DigitalOutput(RobotMap.redLED);
	public static DigitalOutput blue = new DigitalOutput(RobotMap.blueLED);
	public static DigitalOutput green = new DigitalOutput(RobotMap.greenLED);
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

    public void allOff() {
    	red.set(false);
    	blue.set(false);
    	green.set(false);
    }
    
    public static boolean isBlueTeam() {
    	Alliance team = DriverStation.getInstance().getAlliance();
    	if(team == DriverStation.Alliance.Blue) {
    		return true;
    	} 
    	else {
    		return false;
    	}
    }
        
    public static void setTeamColor(boolean turnOn) {
    	if(isBlueTeam()) {
    		red.set(false);
    		if(turnOn) {
    			blue.set(true);
    		} else {
    			blue.set(false);
    		}
    	}
    }
}    