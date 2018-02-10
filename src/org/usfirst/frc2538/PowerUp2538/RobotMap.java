// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc2538.PowerUp2538;

// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.ADXL345_I2C;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
@SuppressWarnings("deprecation")
public class RobotMap {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public static WPI_TalonSRX driveTrainTalonSRX1;
    public static WPI_TalonSRX driveTrainTalonSRX3;
    public static DifferentialDrive driveTrainDifferentialDrive1;
    public static WPI_TalonSRX driveTrainCenterMotor;
    public static DoubleSolenoid driveTrainhUp;
    public static WPI_TalonSRX driveTrainTalonSRX2;
    public static WPI_TalonSRX driveTrainTalonSRX4;
    public static DifferentialDrive driveTrainDifferentialDrive2;
    public static AnalogInput driveTrainRearRangeFinder;
    public static AnalogInput driveTrainforwardRangeFinder;
    public static Compressor pnuematicsCompressor;
    public static WPI_TalonSRX elevatorTalonSRX42;
    public static WPI_TalonSRX elevatorTalonSRX5;
    public static DoubleSolenoid liftDoubleSolenoid1;
    public static DoubleSolenoid liftDoubleSolenoid2;
    public static DoubleSolenoid liftDoubleSolenoid3;
    public static DoubleSolenoid liftDoubleSolenoid4;
    public static DoubleSolenoid boxClappersDoubleSolenoid5;
    public static WPI_TalonSRX boxClappersTalonSRX52;
    public static WPI_TalonSRX boxClappersTalonSRX60;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public static ADXL345_I2C accelerometer;
    public static ADXRS450_Gyro gyro;
    public static void init() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        driveTrainTalonSRX1 = new WPI_TalonSRX(1);
        
        
        driveTrainTalonSRX3 = new WPI_TalonSRX(4);
        
        
        driveTrainDifferentialDrive1 = new DifferentialDrive(driveTrainTalonSRX1, driveTrainTalonSRX3);
        LiveWindow.addActuator("DriveTrain", "Differential Drive 1", driveTrainDifferentialDrive1);
        driveTrainDifferentialDrive1.setSafetyEnabled(true);
        driveTrainDifferentialDrive1.setExpiration(0.1);
        driveTrainDifferentialDrive1.setMaxOutput(1.0);

        driveTrainCenterMotor = new WPI_TalonSRX(3);
        
        
        driveTrainhUp = new DoubleSolenoid(0, 0, 1);
        LiveWindow.addActuator("DriveTrain", "hUp", driveTrainhUp);
        
        driveTrainTalonSRX2 = new WPI_TalonSRX(6);
        
        
        driveTrainTalonSRX4 = new WPI_TalonSRX(7);
        
        
        driveTrainDifferentialDrive2 = new DifferentialDrive(driveTrainTalonSRX2, driveTrainTalonSRX4);
        LiveWindow.addActuator("DriveTrain", "Differential Drive 2", driveTrainDifferentialDrive2);
        driveTrainDifferentialDrive2.setSafetyEnabled(true);
        driveTrainDifferentialDrive2.setExpiration(0.1);
        driveTrainDifferentialDrive2.setMaxOutput(1.0);

        driveTrainRearRangeFinder = new AnalogInput(0);
        LiveWindow.addSensor("DriveTrain", "RearRangeFinder", driveTrainRearRangeFinder);
        
        driveTrainforwardRangeFinder = new AnalogInput(1);
        LiveWindow.addSensor("DriveTrain", "forwardRangeFinder", driveTrainforwardRangeFinder);
        
        pnuematicsCompressor = new Compressor(0);
        LiveWindow.addActuator("pnuematics", "Compressor ", pnuematicsCompressor);
        
        elevatorTalonSRX42 = new WPI_TalonSRX(9);
        
        
        elevatorTalonSRX5 = new WPI_TalonSRX(5);
        
        
        liftDoubleSolenoid1 = new DoubleSolenoid(1, 0, 1);
        LiveWindow.addActuator("Lift", "Double Solenoid 1", liftDoubleSolenoid1);
        
        liftDoubleSolenoid2 = new DoubleSolenoid(1, 2, 3);
        LiveWindow.addActuator("Lift", "Double Solenoid 2", liftDoubleSolenoid2);
        
        liftDoubleSolenoid3 = new DoubleSolenoid(1, 4, 5);
        LiveWindow.addActuator("Lift", "Double Solenoid 3", liftDoubleSolenoid3);
        
        liftDoubleSolenoid4 = new DoubleSolenoid(1, 6, 7);
        LiveWindow.addActuator("Lift", "Double Solenoid 4", liftDoubleSolenoid4);
        
        boxClappersDoubleSolenoid5 = new DoubleSolenoid(0, 4, 5);
        LiveWindow.addActuator("BoxClappers", "Double Solenoid 5", boxClappersDoubleSolenoid5);
        
        boxClappersTalonSRX52 = new WPI_TalonSRX(10);
        
        
        boxClappersTalonSRX60 = new WPI_TalonSRX(11);
        
        

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    }
}
