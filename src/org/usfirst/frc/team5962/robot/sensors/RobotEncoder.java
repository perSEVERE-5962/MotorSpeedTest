package org.usfirst.frc.team5962.robot.sensors;


import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class RobotEncoder {
	// encoders
Encoder encoderLeft;
	
	public RobotEncoder() {
		
		// distance per pulse = 18 degrees
		// pulse per revolution = 20
		
		encoderLeft = new Encoder(0, 1, true, Encoder.EncodingType.k4X);
		encoderLeft.setDistancePerPulse(0.035); // inches .027 for treads
												// inches .035 for small wheels
												// inches .052 for big wheels
		
	}
	
	public void reset() {
		encoderLeft.reset();
	}
	
	public double getRPM() {
		double period = encoderLeft.getPeriod();
		return Math.abs(60/(period*20));
	}
	
	public double getDistance() {
		double distance = encoderLeft.getDistance();
		SmartDashboard.putString("Encoder Distance", "" + distance);
		return distance;
	}
}
