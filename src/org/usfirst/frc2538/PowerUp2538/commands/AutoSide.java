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

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc2538.PowerUp2538.Robot;
import org.usfirst.frc2538.PowerUp2538.subsystems.*;

/**
 *
 */
public class AutoSide extends CommandGroup {


    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=PARAMETERS
    public AutoSide() {

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=PARAMETERS
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=COMMAND_DECLARATIONS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=COMMAND_DECLARATIONS
    
    	// negative y means "left"; x is always positive, h is the number of rotations 
    	// of h wheel:
    	// Going to the switch if it's on our side
    	addSequential(new AutoLowerHWheel(),1);
    	addSequential(new AutoSaveEncoders());
    	addSequential(new AutoDriveAngle(-0.7,0.5,0.5*Robot.driveTrain.hWheelCountsPerFt), 5);
    	//addSequential(new AutoContinueMoving(),2);
    	addSequential(new AutoDriveStraight(-0.7,5*Robot.driveTrain.mainWheelCountsPerFt),3);
    	addSequential(new AutoElevatorUp(),4);
    	addSequential(new AutoExtendBoxClappers(),1);// return is false so it needs to timeout
    	addSequential(new AutoPutBlock(),4);
    	
    	// Going to the scale
    	addSequential(new AutoLiftHWheel(),0.5);
    	addSequential(new AutoSaveEncoders());
    	addSequential(new AutoDriveStraightScale(-0.7,12*Robot.driveTrain.mainWheelCountsPerFt),5);
    	addParallel(new AutoElevatorSecondFloorScale(),4);
    	addSequential(new AutoSaveEncoders());
    	addSequential(new AutoDriveStraightScale(-0.7,10*Robot.driveTrain.mainWheelCountsPerFt),4);
    	addSequential(new AutoTurn(),3);
    	addSequential(new AutoExtendClappersScale(),1);
    	addSequential(new AutoPutBoxScale(),2);
    } 
    protected void initialize() {
    	super.initialize();
    	Robot.ourSide='L';
    	SmartDashboard.putString("ourSide", "L");
    }
}
