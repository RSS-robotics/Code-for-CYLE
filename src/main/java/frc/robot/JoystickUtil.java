package main.java.frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.GenericHID;
import java.util.ArrayList;

/**
 * How to implement into code:
 * 
 * @DriveTrain
 * ArrayList<JoystickUtil> _joystickUtil = new ArrayList<JoystickUtil>();
 * 
 * @DriveTrain.teleopPeriodic()
 * JoystickUtil.update(_joystickUtil);
 * 
 * @DriveTrain.robotInit
 * _joystickUtil.add(new JoystickUtil(_joystick, button, debounce_period, isToggle));
 */

public class JoystickUtil 
{
    private Joystick _joystick;

    private boolean isToggle;
    private boolean toggleOn = false;
    private boolean togglePressed = false;

    private double latest;
    private double debounce_period;

    private int button;

    public JoystickUtil(Joystick _joystick, int button, double debounce_period, boolean isToggle) {
        this._joystick = _joystick;
        this.isToggle = isToggle;
        this.latest = 0.0f;
        this.debounce_period = debounce_period;
        this.button = button;
    }

    public void setDebouncePeriod(double debounce_period) {
        this.debounce_period = debounce_period;
    }

    public void updateToggle() {
        if (isToggle) {
            togglePressed = (_joystick.getRawButton(button) && !togglePressed) ? true : false;
            toggleOn = (_joystick.getRawButton(button) && !togglePressed) ? !toggleOn : toggleOn;
        }
    }

    public boolean get() {
        double now = Timer.getFPGATimestamp();
        if(_joystick.getRawButton(button)) {
            if ((now-latest) > debounce_period) {
                latest = now;
                return true;
            }
        }
        return false;
    }

    public static void update(ArrayList<JoystickUtil> arr) {
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i).get()) {
                System.out.println();
            }
            arr.get(i).updateToggle();
          }
    }
}