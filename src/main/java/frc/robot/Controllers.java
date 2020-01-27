package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import frc.robot.lib.gamepads.InterLinkElite;
import frc.robot.lib.gamepads.LogitechDualAction;
import frc.robot.lib.gamepads.LogitechF310;
import frc.robot.lib.gamepads.XboxOne;
import frc.robot.lib.gamepads.XboxOneElite;

/**
 * Use this class to map controls between different controllers.
 *
 * @author FRC 1778 Chill Out
 */
public class Controllers {

  private static Controllers instance = new Controllers();

  public enum ControllerType {
    INTERLINK_ELITE_CONTROLLER {
      @Override
      public String toString() { return "Interlink Elite Controller"; } },

    FREEZY_CONTROLLER {
      @Override
      public String toString() { return "Freezy Controller"; } },

    FREEZY_BOARD {
      @Override
      public String toString() { return "Freezy Board";  }  },
      
    LOGITECH_DUAL_ACTION {
      @Override
      public String toString() { return "Logitech Dual Action Gamepad"; } },

    LOGITECH_F310 {
      @Override
      public String toString() { return "Logitech F310 Gamepad"; } },
      
    XBOX_ONE {
      @Override
      public String toString() { return "Xbox one Gamepad"; } },

    XBOX_ONE_ELITE {
      @Override
      public String toString() { return "Xbox One Elite Controller"; }
 }
  }

  private static final ControllerType DRIVER_CONTROLLER_TYPE = ControllerType.FREEZY_CONTROLLER;
  private static final ControllerType OPERATOR_CONTROLLER_TYPE = ControllerType.FREEZY_BOARD;
  //private static final ControllerType SECOND_OPERATOR_CONTROLLER_TYPE = ControllerType.LOGITECH_F310;


  private Joystick driverController;
  private Joystick operatorController;
  private Joystick secondOperatorController;

  private Controllers() {
    driverController = new Joystick(RobotMap.PORT_DRIVE_CONTROLLER);
    operatorController = new Joystick(RobotMap.PORT_OPERATOR_CONTROLLER);
    secondOperatorController = new Joystick(RobotMap.PORT_SECOND_OPERATOR_CONTROLLER);
  }

  public static Controllers getInstance() {
    return instance;
  }

  public Joystick getDriverController() {
    return driverController;
  }

  public Joystick getOperatorController() {
    return operatorController;
  }

  public Joystick getSecondOperatorController() {
    return secondOperatorController;
  }

  public ControllerType getDriverControllerType() {
    return DRIVER_CONTROLLER_TYPE;
  }

  public ControllerType getOperatorControllerType() {
    return OPERATOR_CONTROLLER_TYPE;
  }

  // Driver Controls
  public double getTranslationY() {
    switch (DRIVER_CONTROLLER_TYPE) {                        
      case INTERLINK_ELITE_CONTROLLER:
        return -driverController.getRawAxis(InterLinkElite.AXIS_LEFT_Y);
      case LOGITECH_DUAL_ACTION:
        return -driverController.getRawAxis(LogitechDualAction.AXIS_LEFT_Y);
      case LOGITECH_F310:
        return -driverController.getRawAxis(LogitechF310.AXIS_LEFT_Y);
      case XBOX_ONE:
        return -driverController.getRawAxis(XboxOne.AXIS_LEFT_Y);
      case XBOX_ONE_ELITE:
        return -driverController.getRawAxis(XboxOneElite.AXIS_LEFT_Y);
      default:
        return 0;
    }
  }

  public double getTranslationX() {
    switch (DRIVER_CONTROLLER_TYPE) {
      case INTERLINK_ELITE_CONTROLLER:
        return -driverController.getRawAxis(InterLinkElite.AXIS_LEFT_X);
      case LOGITECH_DUAL_ACTION:
        return -driverController.getRawAxis(LogitechDualAction.AXIS_LEFT_X);
      case LOGITECH_F310:
        return -driverController.getRawAxis(LogitechF310.AXIS_LEFT_X);
      case XBOX_ONE:
        return -driverController.getRawAxis(XboxOne.AXIS_LEFT_X);
      case XBOX_ONE_ELITE:
        return -driverController.getRawAxis(XboxOneElite.AXIS_LEFT_X);
      default:
        return 0;
    }
  }

  public double getRotation() {
    switch (DRIVER_CONTROLLER_TYPE) {
      case INTERLINK_ELITE_CONTROLLER:
        return -driverController.getRawAxis(InterLinkElite.AXIS_RIGHT_X);
      case LOGITECH_DUAL_ACTION:
        return -driverController.getRawAxis(LogitechDualAction.AXIS_RIGHT_X);
      case LOGITECH_F310:
        return -driverController.getRawAxis(LogitechF310.AXIS_RIGHT_X);
      case XBOX_ONE:
        return -driverController.getRawAxis(XboxOne.AXIS_RIGHT_X);
      case XBOX_ONE_ELITE:
        return -driverController.getRawAxis(XboxOneElite.AXIS_RIGHT_X);
      default:
        return 0;
    }
  }

  public boolean getResetFieldCentric() {
    switch (DRIVER_CONTROLLER_TYPE) {
      case INTERLINK_ELITE_CONTROLLER:
        return !driverController.getRawButton(InterLinkElite.RIGHT_SHOULDER_SWITCH);
      case LOGITECH_DUAL_ACTION:
        return driverController.getRawButton(LogitechDualAction.RIGHT_BUMPER);
      case LOGITECH_F310:
        return driverController.getRawButton(LogitechF310.RIGHT_BUMPER);
      case XBOX_ONE:
        return driverController.getRawButton(XboxOne.RIGHT_BUMPER);
      case XBOX_ONE_ELITE:
        return driverController.getRawButton(XboxOneElite.RIGHT_BUMPER);
      default:
        return false;
    }
  }

  public boolean getFieldCentricToggle() {
    switch (DRIVER_CONTROLLER_TYPE) {
      case INTERLINK_ELITE_CONTROLLER:
        return driverController.getRawButton(InterLinkElite.LEFT_SWITCH);
      case LOGITECH_DUAL_ACTION:
        return driverController.getRawButton(LogitechDualAction.LEFT_TRIGGER);
      case LOGITECH_F310:
        return driverController.getRawAxis(LogitechF310.AXIS_LEFT_TRIGGER) >= 0.5;
      case XBOX_ONE:
        return driverController.getRawAxis(XboxOne.AXIS_LEFT_TRIGGER) >= 0.5;
      case XBOX_ONE_ELITE:
        return driverController.getRawAxis(XboxOneElite.AXIS_LEFT_TRIGGER) >= 0.5;
      default:
        return false;
    }
  }

  

}


