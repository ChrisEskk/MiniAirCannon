/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.RobotMap;
import frc.robot.commands.DoubleArcade;

/**
 * Add your docs here.
 */
public class Drivetrain extends Subsystem {
  Talon frontLeftTalon = new Talon(RobotMap.frontLeft);
  Talon frontRightTalon = new Talon(RobotMap.frontRight);
  Talon backLeftTalon = new Talon(RobotMap.backLeft);
  Talon backRightTalon = new Talon(RobotMap.backRight);

  // Speed Controller
  SpeedControllerGroup leftSpeedGroup = new SpeedControllerGroup(frontLeftTalon, backLeftTalon);
  SpeedControllerGroup rightSpeedGroup = new SpeedControllerGroup(frontRightTalon, backRightTalon);

  DifferentialDrive drive = new DifferentialDrive(leftSpeedGroup, rightSpeedGroup);

  public void arcadeDrive(double xSpeed, double zRotation) {
    drive.arcadeDrive(xSpeed, zRotation);
  }
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new DoubleArcade());
    // setDefaultCommand(new MySpecialCommand());
  }
}
