/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {

	// For example to map the left and right motors, you could define the
	// following variables to use with your drivetrain subsystem.
	// public static int leftMotor = 1;
	// public static int rightMotor = 2;

/*


ALL CODE BELOW THIS IS TO BE TRANSLATED TO PORTSSSSSS





*/

	// Joystick
	public static final int PORT_DRIVE_CONTROLLER = 0;
  	public static final int PORT_OPERATOR_CONTROLLER = 1;
	public static final int PORT_SECOND_OPERATOR_CONTROLLER = 2;
	  
	// Solenoids
	public static final int SHOOTER_PITCH_SOLENOID_DEPLOY = 0;
	public static final int SHOOTER_PITCH_SOLENOID_RETRACT = 1;

	// Switches
	public static final int SHOOTER_SWITCH = 0;

	// Encoders
	public static final int DRIVETRAIN_DRIVE_ENCODER_A = 1;
	public static final int DRIVETRAIN_DRIVE_ENCODER_B = 2;
	

	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;
}
