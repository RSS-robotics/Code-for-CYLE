/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import frc.robot.Ports;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.RobotMap;
import frc.robot.commands.drive.ArcadeDrive;

/**
 * Drivetrain - contains all commands for moving the robot
 */
public class Drivetrain extends Subsystem {
  WPI_VictorSPX driveFrontLeft = new WPI_VictorSPX(Ports.RTFRNT);
  WPI_VictorSPX driveRearLeft = new WPI_VictorSPX(Ports.LTBCK);

  WPI_VictorSPX driveFrontRight = new WPI_VictorSPX(Ports.RTFRNT);
  WPI_VictorSPX driveRearRight = new WPI_VictorSPX(Ports.RTBCK);

  SpeedControllerGroup driveLeft = new SpeedControllerGroup(driveFrontLeft, driveRearLeft);
  SpeedControllerGroup driveRight = new SpeedControllerGroup(driveFrontRight, driveRearRight);

  DifferentialDrive drive = new DifferentialDrive(driveLeft, driveRight);

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new ArcadeDrive());
  }

  public void arcadeDrive(double speed, double rotation) {
    drive.arcadeDrive(speed, rotation);
  }

  public void tankDrive(double left, double right) {
    drive.tankDrive(left, right);
  }

  public void stopDrive() {
    drive.stopMotor();
  }
}
