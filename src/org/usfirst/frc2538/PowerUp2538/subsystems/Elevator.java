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

import org.usfirst.frc2538.PowerUp2538.Robot;
import org.usfirst.frc2538.PowerUp2538.RobotMap;
import org.usfirst.frc2538.PowerUp2538.commands.*;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import com.ctre.phoenix.ErrorCode;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.LimitSwitchNormal;
import com.ctre.phoenix.motorcontrol.LimitSwitchSource;
import com.ctre.phoenix.motorcontrol.RemoteLimitSwitchSource;
// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS


/**
 *
 */
public class Elevator extends Subsystem {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    private final WPI_TalonSRX talonSRX42 = RobotMap.elevatorTalonSRX42;
    private final WPI_TalonSRX talonSRX5 = RobotMap.elevatorTalonSRX5;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    private final Joystick elevatorJoystick = Robot.oi.elevatorJoystick;
    
    @Override
    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        setDefaultCommand(new ElevatorManualMovement());

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

    public void configurePID (){
    	talonSRX42.selectProfileSlot(0, 0);
    	talonSRX42.config_kP(0, 1.25e-4, 0);
    	talonSRX42.config_kI(0,1.0e-5,0);
    	talonSRX42.config_kD(0,1.0e-5,0);
    	talonSRX42.config_kP(0,0.0,0);
    }
    
    public void setElevatorPID(double target){
    	talonSRX5.follow(talonSRX42);
    	talonSRX42.set(ControlMode.Position,target);    	
    }
    
    public void moveElevatormanually(){
    	double y = elevatorJoystick.getY();
    	talonSRX42.set(y);
    	int ecv = talonSRX42.getSensorCollection().getQuadraturePosition();
		SmartDashboard.putNumber(" encoder", ecv);
		
    }
    
    private static final int timeoutLimitSwitch = 0; 
    
    public void setUpperLimitSwitch(){
    	talonSRX42.configForwardLimitSwitchSource(LimitSwitchSource.FeedbackConnector,
    			LimitSwitchNormal.NormallyOpen,timeoutLimitSwitch);
    	talonSRX42.overrideLimitSwitchesEnable(true);
    }
    
    public void setLowerLimitSwitch(){
    	talonSRX42.configReverseLimitSwitchSource(LimitSwitchSource.FeedbackConnector,
    			LimitSwitchNormal.NormallyOpen,timeoutLimitSwitch);
    	talonSRX42.overrideLimitSwitchesEnable(true);
    }
    
    public void printPID(){
    	SmartDashboard.putNumber("PID 42 posistion", talonSRX42.getSelectedSensorPosition(0));
    	SmartDashboard.putNumber("PID 42 velocity", talonSRX42.getSelectedSensorVelocity(0));
    	SmartDashboard.putString("PID 42 error code", 
    			ErrorCode.valueOf(talonSRX42.getClosedLoopError(0)).name());
    	SmartDashboard.putNumber("PID 42 accum", talonSRX42.getIntegralAccumulator(0));
    }
    
    public void printEncoders(){
    	double 	wheelEncoderValue = talonSRX42.getSensorCollection().getQuadraturePosition();
    	SmartDashboard.putNumber("encoder 42 value", wheelEncoderValue);
    	wheelEncoderValue = talonSRX5.getSensorCollection().getQuadraturePosition();
    	SmartDashboard.putNumber("encoder 5 value", wheelEncoderValue);
    }
    public void disablePID(){
    	talonSRX42.set(ControlMode.Disabled,0);
    	talonSRX5.set(ControlMode.Disabled,0);
    }
    
}   


