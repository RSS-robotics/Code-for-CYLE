package main.java.frc.robot;

import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.AnalogOutput;
import edu.wpi.first.wpilibj.AnalogTrigger;
import edu.wpi.first.wpilibj.Counter;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.SampleRobot;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class NavXRotation implements PIDOutput{

    AHRS ahrs;
    RobotDrive myRobot;
    Joystick stick;
    PIDController turnController;
    double rotateToAngleRate;

    private final static double kP = 0.03f;
    private final static double kI = 0.00f;
    private final static double kD = 0.00f;
    private final static double kF = 0.00f;

    private final static double kToleranceDegrees = 2.0f;

    private double currentRotationRate = 0;

    public NavXRotation() {

        myRobot = new RobotDrive(0, 1);
        myRobot.setExpiration(0.1);

        try {
            ahrs = new AHRS(SPI.Port.kMXP);
        } catch (RuntimeException ex) {
            DriverStation.reportError("Error instantiating navX-MXP:  " + ex.getMessage(), true);
        }


        turnController = new PIDController(kP, kI, kD, kF, ahrs, this);
        turnController.setInputRange(-180.0f,  180.0f);
        turnController.setOutputRange(-1.0, 1.0);
        turnController.setAbsoluteTolerance(kToleranceDegrees);
        turnController.setContinuous(true);

        LiveWindow.addActuator("DriveSystem", "RotateController", turnController);
    }

    public double getCurrentRotationRate() {
        return currentRotationRate;
    } 
    public AHRS getAHRS() {
        return ahrs;
    }

    public void calibrate() {
        ahrs.reset();
        rotating();
    }

    public void rotate(double angle) {
        turnController.setSetPoint(angle);
        turnController.enable();
        currentRotationRate = rotateToAngleRate;
    }   
}
