// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Joystick;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {

  public DriveTrain dt;
  // public Shooter sh;
  // public Sensors se;
  // public Intake in;
  // public Climbing cl;
  public Test ts;

  public Joystick j;

  public WPI_TalonSRX indexMotor;


  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  @Override
  public void robotInit() {

    // dt = new DriveTrain();
    // sh = new Shooter();
    // se = new Sensors();
    // in = new Intake();
    // cl = new Climbing();
    
    
    j = new Joystick(0);

    // se.smartdashboardSensorsInit();

    // se.cameraInit();
  }

  /**
   * This function is called every robot packet, no matter the mode. Use this for items like
   * diagnostics that you want ran during disabled, autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before LiveWindow and
   * SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
  }

  /**
   * This autonomous (along with the chooser code above) shows how to select between different
   * autonomous modes using the dashboard. The sendable chooser code works with the Java
   * SmartDashboard. If you prefer the LabVIEW Dashboard, remove all of the chooser code and
   * uncomment the getString line to get the auto name from the text box below the Gyro
   *
   * <p>You can add additional auto modes by adding additional comparisons to the switch structure
   * below with additional strings. If using the SendableChooser make sure to add them to the
   * chooser code above as well.
   */
  @Override
  public void autonomousInit() {
    // dt.backUp();
    
  }

  /** This function is called periodically during autonomous. */
  @Override
  public void autonomousPeriodic() {
    
  }

  /** This function is called once when teleop is enabled. */
  @Override
  public void teleopInit() {
    // sh.smartdashboardShooterInit();
  }

  /** This function is called periodically during operator control. */
  @Override
  public void teleopPeriodic() {


    // se.updateSensorsPlaceNumbers();
    // sh.updateShooterMotorSpeeds();

    // dt.mecDrive(j); 

    // Shooting

    // Manual Shoot
    
    // if(j.getRawButton(1)) {
    //   sh.manualShoot();
    // } else {
    //   sh.stopShoot();
    // }

    // Smart Shoot
    // if(j.getRawButton(1)) {
    //   if(dt.alignSelf(se)) {
    //     sh.smartShoot(se.calcDistance());
    //   } 
    // } else {
    //   if(dt.aligning) {
    //     dt.fullStop();
    //   }
    //   if(sh.isShooting()) {
    //     sh.stopShoot();
    //   }
    // }

    // Intake

    // if(j.getRawButton(1)) {
    //   indexMotor.set(ControlMode.Velocity, ((int) (1000) * 600)/2048);
    // }

    if(j.getRawButton(5)){
      in.runIntake();
    }
    else{
      in.stopIntake();
    }

    if(j.getRawButton(6)){
      in.manualIndex();
    }
    else{
      in.stopManualIndex();
    }

  }

  /** This function is called once when the robot is disabled. */
  @Override
  public void disabledInit() {
    // se.closeUltrasonic();
  }

  /** This function is called periodically when disabled. */
  @Override
  public void disabledPeriodic() {}

  /** This function is called once when test mode is enabled. */
  @Override
  public void testInit() {
    ts = new Test();
    ts.smartdashboardInit();
  }

  /** This function is called periodically during test mode. */
  @Override
  public void testPeriodic() {
    ts.callPeriodic(j);
  }
}
