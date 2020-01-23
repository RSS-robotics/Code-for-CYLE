package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.GenericHID;
import java.util.ArrayList;

public class ButtonDebouncer 
{
    private Joystick m_stick;
    private int buttonNum;
    private double latest;
    private double debounce_period;

    public ButtonDebouncer(Joystick m_stick, int buttonNum) {
        this.m_stick = m_stick;
        this.buttonNum = buttonNum;
        this.latest = 0;
        this.debounce_period = 0.5;
    }

    public ButtonDebouncer(Joystick m_stick, int buttonNum, double period) {
        this.m_stick = m_stick;
        this.buttonNum = buttonNum;
        this.latest = 0;
        this.debounce_period = period;
    }

    public void setDebouncePeriod(double period) {
        this.debounce_period = period;
    }

    public boolean get() {
        double now = Timer.getFPGATimestamp();
        if(m_stick.getRawButton(buttonNum)) {
            if ((now-latest) > debounce_period) {
                latest = now;
                return true;
            }
        }
        return false;
    }
    public static void buttonDebouncers(ArrayList<ButtonDebouncer> arr) {
        for (int i = 0; i < arr.size(); i++) {
          if (arr.get(i).get()) {
            System.out.println();
          }
        }
      }
}
