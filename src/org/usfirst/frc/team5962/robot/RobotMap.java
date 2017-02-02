package org.usfirst.frc.team5962.robot;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Victor;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	
	public static RobotDrive myRobot;
	public static Victor inTakeVictor;
	
	public static void init() {
		inTakeVictor = new Victor(3);
		inTakeVictor.setSafetyEnabled(false);
	}
}
