package main.java.frc.robot;//.subsystems;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;//double check this
import edu.wpi.first.wpilibj.command.Command;//double check this

public class Shooter extends Subsystem implements PIDOutput{

    Spark _shootMotor = new Spark(RobotMap.SHOOT);
    PIDController pidController;
    AHRS ahrs;
    public Joystick _joystick;

    public double kp = 0.00f;
    public double ki = 0.00f;
    public double kd = 0.00f;
    public double kf = 0.00f;
    public final double maxRPM = 21020;
    public final double rpm = 0;
    public final double maxV = 12;
    public double setPoint;


    public Shooter(final Joystick _joystick, double setPoint) {
        this._joystick = _joystick;
        ahrs = new AHRS(SPI.Port.kMXP);//double check this
        pidController = _shootMotor.getPIDController();
        this.setPoint = setPoint;

        LiveWindow.addActuator("ShootSystem", "ShootController", turnController);
        SmartDashboard.putNumber("sP Gain", kP);
        SmartDashboard.putNumber("sI Gain", kI);
        SmartDashboard.putNumber("sD Gain", kD);
    }

    @Override
    public void initDefaultCommand() {

    }

    public void shoot() {
        //_shootMotor.set(maxV / maxRPM * setpoint);
        //"max voltage" / "max rpm" * "desired rpm"
        rpm = setPoint;
    }

    public void teleopPeriodic() {

        /**
         * double setPoint = m_stick.getY()*maxRPM;
         *  m_pidController.setReference(setPoint, ControlType.kVelocity);
         */

        final double p = SmartDashboard.getNumber("sP Gain", 0);
        final double i = SmartDashboard.getNumber("sI Gain", 0);
        final double d = SmartDashboard.getNumber("sD Gain", 0);

        if (p != kp) {pidController.setP(p); kp = p;}
        if (i != ki) {pidController.setI(i); ki = i;}
        if (p != kp) {pidController.setD(d); kp = p;}

        m_pidController.setReference(setPoint, ControlType.kVelocity);
    }

    public void stop() {
        _shootMotor.set(0.0);
        rpm = 0;
    }
}