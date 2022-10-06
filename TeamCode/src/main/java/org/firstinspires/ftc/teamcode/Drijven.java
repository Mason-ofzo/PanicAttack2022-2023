package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

public class Drijven extends OpMode {
    DcMotor motorLeftFront;
    DcMotor motorRightFront;
    DcMotor motorLeftBack;
    DcMotor motorRightBack;

    @Override
    public void init() {
        motorLeftBack = hardwareMap.dcMotor.get("linksachter");
        motorRightBack = hardwareMap.dcMotor.get("rechtsachter");
        motorLeftFront = hardwareMap.dcMotor.get("linksvoor");
        motorRightFront = hardwareMap.dcMotor.get("rechtsvoor");
        motorRightFront.setDirection(DcMotorSimple.Direction.REVERSE);
        motorRightBack.setDirection(DcMotorSimple.Direction.REVERSE);
    }


    @Override
    public void start(){

    }


    @Override
    public void stop(){

    }

    @Override
    public void loop() {
        //moeten alleen nog schuin
        motorRightBack.setPower(gamepad1.left_stick_y+gamepad1.left_stick_x*-1+gamepad1.right_stick_x);
        motorLeftBack.setPower(gamepad1.left_stick_y+gamepad1.left_stick_x+gamepad1.right_stick_x*-1);
        motorRightFront.setPower(gamepad1.left_stick_y+gamepad1.left_stick_x+gamepad1.right_stick_x);
        motorLeftFront.setPower(gamepad1.left_stick_y+gamepad1.left_stick_x*-1+gamepad1.right_stick_x*-1);
      
    }
    

}