
package org.usfirst.frc.team5962.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import org.usfirst.frc.team5962.robot.commands.RunArcadeGame;
import org.usfirst.frc.team5962.robot.subsystems.Drive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

 /* The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	public static OI oi;
	
	public static Drive drive;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
		RobotMap.init();
		
		drive = new Drive();
		oi = new OI();
	}
	
	/**
     * This function is called once each time the robot enters Disabled mode.
     * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
     */
    public void disabledInit(){
    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}


    public void autonomousInit() {
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
    }

    public void teleopInit() {
//		Command command = new RunArcadeGame();
//		command.start();
    	
    }

    /**
     * This function is called periodically during operator control
     */
    double speedValue=0;
    boolean buttonRead=false;
    int waitState=0;
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        if (!buttonRead) {
	        if (oi.getGreenButton()) {
	        	speedValue=0.30;
	        } else if (oi.getRedButton()) {
	        	speedValue=0.40;
	        } else if (oi.getBlueButton()) {
	        	speedValue=0.50;
	        } else if (oi.getYellowButton()) {
	        	speedValue=0.60;      	
	        } else if (oi.getStepDownButton()) {
	        	speedValue=speedValue-0.01;
	        } else if (oi.getStepUpButton()) {
	        	speedValue=speedValue+0.01;
	        } else {
	       		// do nothing
	        }
	        buttonRead=true;
	        waitState=0;
        } else {
        	if (waitState>10) {
        		buttonRead=false;
        	}
        	waitState++;
        }
    	RobotMap.inTakeVictor.set(speedValue);
    	SmartDashboard.putString("Controller Speed Value", (int)(speedValue*100) + "%");
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
       LiveWindow.run();		
	}
}
