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

import java.lang.reflect.Field;

import org.usfirst.frc2538.PowerUp2538.Robot;
import org.usfirst.frc2538.PowerUp2538.RobotMap;
import org.usfirst.frc2538.PowerUp2538.commands.*;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import com.ctre.phoenix.ErrorCode;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.Faults;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.LimitSwitchNormal;
import com.ctre.phoenix.motorcontrol.LimitSwitchSource;
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
    private Joystick elevatorJoystick; 
    public boolean cancelManual;
    
    @Override
    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        setDefaultCommand(new ElevatorManualMovement());

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
        elevatorJoystick = Robot.oi.elevatorJoystick;
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
    	final int timeOut =0;
    	talonSRX42.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder,0,0);
    	talonSRX42.setIntegralAccumulator(0.0, 0,timeOut);
    	talonSRX42.selectProfileSlot(0, 0);
    	talonSRX42.configNominalOutputForward(0.0,timeOut);
    	talonSRX42.configNominalOutputReverse(0.0,timeOut);
    	talonSRX42.configPeakOutputForward(12.0,timeOut);
    	talonSRX42.configPeakOutputReverse(-12.0, timeOut);
    	
    	talonSRX42.config_kP(0, 1.25e-1,timeOut);
    	talonSRX42.config_kI(0,0.0,timeOut);
    	talonSRX42.config_kD(0,0.0,timeOut);
    	talonSRX42.config_kF(0,0.0,timeOut);
    	talonSRX42.configAllowableClosedloopError(10,0,timeOut);
    }
    
    public void setElevatorPID(double target){
    	talonSRX5.follow(talonSRX42);
    	talonSRX5.setInverted(true);
    	talonSRX42.set(ControlMode.Position,target);    	
    }
    
    public void moveElevatormanually(){
    	talonSRX5.follow(talonSRX42);
    	talonSRX5.setInverted(true);
    	double y = elevatorJoystick.getY();
     	talonSRX42.set(y);
    	//int ecv = talonSRX42.getSensorCollection().getQuadraturePosition();
		//SmartDashboard.putNumber(" encoder", ecv);
		
    }
    
    public void turnManualOff() {
    	cancelManual=true;
    }
    
    private final int rangeTolerance=300;
    
    public boolean isNear(int target) {
    	return (Math.abs(talonSRX42.getSensorCollection().getQuadraturePosition()-target)<rangeTolerance);
    }
    
    private static final int timeoutLimitSwitch = 0; 
    
    public void setUpperLimitSwitch(){
    	talonSRX42.configForwardLimitSwitchSource(LimitSwitchSource.FeedbackConnector,
    			LimitSwitchNormal.NormallyClosed,timeoutLimitSwitch);
    	talonSRX42.overrideLimitSwitchesEnable(true);
    }
    
    public void setLowerLimitSwitch(){
    	talonSRX42.configReverseLimitSwitchSource(LimitSwitchSource.FeedbackConnector,
    			LimitSwitchNormal.NormallyClosed,timeoutLimitSwitch);
    	talonSRX42.overrideLimitSwitchesEnable(true);
    }
    
    private int countFaults() {
    	Faults myFaults=new Faults();
    	talonSRX42.getFaults(myFaults);
    	int faultCount=0;
    	for(Field field:myFaults.getClass().getDeclaredFields()){
    		try {
				if(field.getBoolean(myFaults)) {
					//SmartDashboard.putStrings("Fault is",field.getName());
					faultCount+=1;
				}
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    	return faultCount;
    }
    
    public void printPID(){
    	SmartDashboard.putNumber("PID 42 posistion ", talonSRX42.getSelectedSensorPosition(0));
    	//SmartDashboard.putNumber("PID 42 velocity ", talonSRX42.getSelectedSensorVelocity(0));
    	//SmartDashboard.putString("PID 42 error code ", 
    		//	ErrorCode.valueOf(talonSRX42.getClosedLoopError(0)).name());
   // 	SmartDashboard.putNumber("PID 42 accum ", talonSRX42.getIntegralAccumulator(0));
    	SmartDashboard.putNumber("error", talonSRX42.getClosedLoopError(0));
    	SmartDashboard.putNumber("PID42 OutPut", talonSRX42.getMotorOutputVoltage());
    	SmartDashboard.putNumber("PID42 Faults", countFaults());
    }
    
    public void printEncoders(){
    	double 	wheelEncoderValue = talonSRX42.getSensorCollection().getQuadraturePosition();
    	SmartDashboard.putNumber("encoder 42 value", wheelEncoderValue);
    	SmartDashboard.putBoolean("Forward switch closed ", talonSRX42.getSensorCollection().isFwdLimitSwitchClosed());
    	SmartDashboard.putBoolean("Reverse switch closed ", talonSRX42.getSensorCollection().isRevLimitSwitchClosed());
    	//SmartDashboard.putNumber("motorvoltage",talonSRX42.getMotorOutputVoltage());
    	
    	//wheelEncoderValue = talonSRX5.getSensorCollection().getQuadraturePosition();
    	//SmartDashboard.putNumber("encoder 5 value", wheelEncoderValue):
    }
    public void disablePID(){
    	talonSRX42.set(ControlMode.Disabled,0);
    	talonSRX5.set(ControlMode.Disabled,0);
    }
    public boolean noVoltage(){
    	return talonSRX42.getMotorOutputVoltage()<0.05 
    			&& talonSRX42.getMotorOutputVoltage()>-0.05;		
    }
    
    private int htdCount=0;
    public boolean hitTheDeck(){
    	talonSRX5.setInverted(true);
    	talonSRX5.follow(talonSRX42);
    	boolean theSwitch = talonSRX42.getSensorCollection().isRevLimitSwitchClosed();
    	SmartDashboard.putNumber("hit Pid count",htdCount++);
    	if(theSwitch) {
    		talonSRX42.set(0.4);
    		SmartDashboard.putString("hit pid", "yes");
    	} else {
    		talonSRX42.set(0);
    		SmartDashboard.putString("hit pid", "stop");
    		talonSRX42.getSensorCollection().setQuadraturePosition(0, 0);
    	}
    	return !theSwitch;		
    }
   public void stop(){
	   talonSRX42.set(0);
	   talonSRX5.set(0);
   }
}   







