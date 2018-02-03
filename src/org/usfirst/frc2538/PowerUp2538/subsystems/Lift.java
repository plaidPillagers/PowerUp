// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc2538.PowerUp2538.subsystems;

import org.usfirst.frc2538.PowerUp2538.RobotMap;
import org.usfirst.frc2538.PowerUp2538.commands.*;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.DoubleSolenoid;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS


/**
 *
 */
public class Lift extends Subsystem {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    private final DoubleSolenoid doubleSolenoid1 = RobotMap.liftDoubleSolenoid1;
    private final DoubleSolenoid doubleSolenoid2 = RobotMap.liftDoubleSolenoid2;
    private final DoubleSolenoid doubleSolenoid3 = RobotMap.liftDoubleSolenoid3;
    private final DoubleSolenoid doubleSolenoid4 = RobotMap.liftDoubleSolenoid4;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
     
    @Override
    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }

    @Override
    public void periodic() {
        // Put code here to be run every loop

    }

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public void raiseFrame(){
    	doubleSolenoid1.set(DoubleSolenoid.Value.kForward);
  		 SmartDashboard.putBoolean("Rising Frame",true);
  	 }
  	 public void lowerFrame(){
  		doubleSolenoid1.set(DoubleSolenoid.Value.kReverse);
 		 SmartDashboard.putBoolean("Lowering Frame",false);

  	 }

}

