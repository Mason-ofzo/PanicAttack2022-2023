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
    'armmotor' motorGrabinator;
    'pionhouder'motorConeHolder;
    // de dingen tussen hoge kommas moeten nog worden vervangen met de motornamen
    @Override
    public void init() {
        motorLeftBack = hardwareMap.dcMotor.get("linksachter");
        motorRightBack = hardwareMap.dcMotor.get("rechtsachter");
        motorLeftFront = hardwareMap.dcMotor.get("linksvoor");
        motorRightFront = hardwareMap.dcMotor.get("rechtsvoor");
        motorRightFront.setDirection(DcMotorSimple.Direction.REVERSE);
        motorRightBack.setDirection(DcMotorSimple.Direction.REVERSE);
        motorGrabinator = hardwareMap.'armmotor'.get("armextender);
        motorConeHolder = hardwareMap.'pionhouder'.get("mond");
        // de dingen tussen hoge kommas moeten nog worden vervangen met de motornamen
    }


    @Override
    public void start(){

    }


    @Override
    public void stop(){

    }

    @Override
    public void loop() {
        
        motorRightBack.setPower(gamepad1.left_stick_y+gamepad1.left_stick_x*-1+gamepad1.right_stick_x+gamepad1.left_stick_xy);
        motorLeftBack.setPower(gamepad1.left_stick_y+gamepad1.left_stick_x+gamepad1.right_stick_x*-1+gamepad1.left_stick_xy*-1);
        motorRightFront.setPower(gamepad1.left_stick_y+gamepad1.left_stick_x+gamepad1.right_stick_x+gamepad1.left_stick_xy*-1);
        motorLeftFront.setPower(gamepad1.left_stick_y+gamepad1.left_stick_x*-1+gamepad1.right_stick_x*-1+gamepad1.left_stick_xy);
        motograbinator.setPower(gamepad2.right_button+gamepad2.left_button*-1);
        motorconeholder.setPower(gamepad2.A+gamepad2.X*-1);
        // moet nog getest worden
    }
    

}
