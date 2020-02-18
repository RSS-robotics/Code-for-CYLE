package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import java.util.ArrayList;

public class Toggle 
{
    private boolean toggleOn = false;
    private boolean togglePressed = false;
    private Joystick m_stick;
    private int button;
    

    public Toggle(Joystick m_stick, int button) {
        this.m_stick = m_stick;
        this.button = button;
    }
    public void updateToggle() {
        if (m_stick.getRawButton(button) && !togglePressed) {
            toggleOn = !toggleOn;
            togglePressed = true;
        } else {
            togglePressed = false;
        }
    }
    public static void updateToggles(ArrayList<Toggle> arr) {
        for (int i = 0; i < arr.size(); i++) {
          arr.get(i).updateToggle();
        }
      }
}