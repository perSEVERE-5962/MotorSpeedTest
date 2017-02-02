package org.usfirst.frc.team5962.robot;

import edu.wpi.first.wpilibj.Joystick;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	public Joystick gamePad1;
	
	public OI() {
		// add game controllers
		gamePad1 = new Joystick(0);	
	}
	
	public boolean getGreenButton() { return gamePad1.getRawButton(1); }
	public boolean getRedButton() { return gamePad1.getRawButton(2); }
	public boolean getBlueButton() { return gamePad1.getRawButton(3); }
	public boolean getYellowButton() { return gamePad1.getRawButton(4); }
	public boolean getStepDownButton() { return gamePad1.getRawButton(7); }
	public boolean getStepUpButton() { return gamePad1.getRawButton(8); }

}

