/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.Spark;
/**
 * Add your docs here.
 */
public class Transporter extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  Spark transporterMotor = new Spark(RobotMap.TRANSPORTER_PORT);

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(null);
  }

  public void transporterIntake(double power) {
    transporterMotor.set(power);
  }

  public void transporterOuttake(double power) {
    transporterMotor.set(-power);
  }

  public void stopMotorIn() { 
   transporterMotor.stopMotor();
  }
}
