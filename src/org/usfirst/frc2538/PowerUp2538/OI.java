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

import org.usfirst.frc2538.PowerUp2538.commands.*;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);

    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.

    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:

    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());

    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());

    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());


    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public JoystickButton switchHWheel;
    public JoystickButton raisingBox;
    public JoystickButton loweringBox;
    public JoystickButton output;
    public JoystickButton hitTheDeck;
    public JoystickButton toggleHook;
    public Joystick joystick1;
    public JoystickButton elevatorUp;
    public JoystickButton elevatorDown;
    public JoystickButton switchElevatorToManual;
    public JoystickButton spitOutBox;
    public JoystickButton pickUpBox;
    public JoystickButton firstFloor;
    public JoystickButton boxClappersToggled;
    public Joystick elevatorJoystick;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public OI() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS

        elevatorJoystick = new Joystick(1);
        
        boxClappersToggled = new JoystickButton(elevatorJoystick, 7);
        boxClappersToggled.whenPressed(new ToggleBoxClappers());
        firstFloor = new JoystickButton(elevatorJoystick, 5);
        firstFloor.whenPressed(new ElevatorFirstFloor());
        pickUpBox = new JoystickButton(elevatorJoystick, 4);
        pickUpBox.whileHeld(new SpinClappers());
        spitOutBox = new JoystickButton(elevatorJoystick, 6);
        spitOutBox.whileHeld(new SpitOutClappers());
        switchElevatorToManual = new JoystickButton(elevatorJoystick, 1);
        switchElevatorToManual.whenPressed(new ElevatorManualMovement());
        elevatorDown = new JoystickButton(elevatorJoystick, 2);
        elevatorDown.whenPressed(new ElevatorGroundFloor());
        elevatorUp = new JoystickButton(elevatorJoystick, 3);
        elevatorUp.whenPressed(new ElevatorSecondFloor());
        joystick1 = new Joystick(0);
        
        toggleHook = new JoystickButton(joystick1, 9);
        toggleHook.whenPressed(new HookToggle());
        hitTheDeck = new JoystickButton(joystick1, 10);
        hitTheDeck.whenPressed(new HitGroundFloor());
        output = new JoystickButton(joystick1, 1);
        output.whileHeld(new ReportSensors());
        loweringBox = new JoystickButton(joystick1, 8);
        loweringBox.whenPressed(new Lower());
        raisingBox = new JoystickButton(joystick1, 7);
        raisingBox.whenPressed(new Raise());
        switchHWheel = new JoystickButton(joystick1, 1);
        switchHWheel.whenPressed(new ToggleHWheel());


        // SmartDashboard Buttons

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    }

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
    public Joystick getJoystick1() {
        return joystick1;
    }

    public Joystick getElevatorJoystick() {
        return elevatorJoystick;
    }


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
}

