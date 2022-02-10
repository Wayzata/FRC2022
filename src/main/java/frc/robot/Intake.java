package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class Intake {

    Sensors sensors;
    WPI_TalonSRX intakeMotor;
    WPI_TalonFX indexMotor;
    int ballsIn;

    public Intake() {
        intakeMotor = new WPI_TalonSRX(Variables.intakeMotorPort);
        indexMotor = new WPI_TalonFX(Variables.indexMotorPort);
        sensors = new Sensors();
        ballsIn = 0;
    }

    // Run motors
    public void runIntake(){
        intakeMotor.set(convertToUnitsPer100ms(1000));
    }

    public void stopIntake(){
        intakeMotor.set(0);
    }



    // Indexing (make sure to... )

    public void index(){
        updateSensors();
        if(sensors.beamsBroken[1]){
            if(sensors.beamsBroken[0]){
                indexMotor.set(0);
                ballsIn++;
                sensors.updateBallCount(ballsIn);
            }
            else{
                indexMotor.set(convertToUnitsPer100ms(200));
            }
        }
        else{
            indexMotor.set(convertToUnitsPer100ms(200));
        }

    }

    // if both beams open, run motors till second beam is broken. 
    // if beam two is occupied, run motors till beam one is broken
    // make sure to run a little more
    // pause intake when beam 1 broken

    // have a special "no-indexing" mode

    public void manualIndex(){
        indexMotor.set(convertToUnitsPer100ms(200));
    }

    public void stopManualIndex(){
        indexMotor.set(0);
    }

    // make a function that works with shooter. to move the index motor and clear bb2 and move ball from bb1 to bb2
    public void updateSensors(){
        sensors.updateBeamBreaks();
    }

    // Put the number of currrent balls on the smartdashboard
    

    private double convertToUnitsPer100ms(double rpm) {
        // This function converts RPM to the unit, called "unit," that the motors use.
        double unitsPerMinute = (rpm * 2048);
        double unitsPer100 = unitsPerMinute / 600;
        return unitsPer100;
    }

    private double convertToRPM(double input) {
        // This function converts the unit, called "unit," that the motors use into RPM.
        return ((int) input * 600)/2048;
    }

}
