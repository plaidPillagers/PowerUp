// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc2538.PowerUp2538.commands;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc2538.PowerUp2538.Robot;

/**
 *
 */
public class AutoDriveAngle extends Command {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS
    private double m_x;
    private double m_y;
    private double m_width;
 
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS
    private boolean isfinished = false;

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
    public AutoDriveAngle(double x, double y, double width) {

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING
        m_x = x;
        m_y = y;
        m_width = width;

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        requires(Robot.driveTrain);

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    }

    // Called just before this Command runs the first time

    @Override
    protected void initialize() {
    	if ((Robot.ourSide!='M') && (Robot.ourSide != Robot.switchLetter)) {
    		isfinished = true;
		} else {
			Robot.driveTrain.saveEncoderValues();
			Robot.driveTrain.initAutoVariables();
			if (Robot.switchLeft && m_y > 0) {
				m_y = (-1) * m_y; // negative go left*
			} else if (!Robot.switchLeft && m_y < 0) {
				m_y = (-1) * m_y; // positive for right
			}
			Robot.driveTrain.setXYWidth(m_x, m_y, m_width);
			SmartDashboard.putNumber("Auto m_y", m_y);
			SmartDashboard.putNumber("Auto m_width", m_width);
			Robot.driveTrain.setGyroAngle();
			SmartDashboard.putString("Wall detected", "no");
			isfinished = false;
		}
	}

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
    	isfinished = Robot.driveTrain.driveAngleNoMatterWhat();
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
        return isfinished;
    }

    // Called once after isFinished returns true
    @Override
    protected void end() {
    	Robot.driveTrain.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
    	Robot.driveTrain.stop();
    }
}
