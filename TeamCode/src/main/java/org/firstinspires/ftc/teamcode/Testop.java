package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp
public class Testop extends OpMode {
    private DcMotor motorLeftFront;
    private DcMotor motorRightFront;
    private DcMotor motorLeftBack;
    private DcMotor motorRightBack;
    private double x;
    private double y;
    private double TurnRate;
    private DcMotor motorSlides;
    private Servo Grijp;
    float servo;

    // 'armmotor' motorGrabinator;
    // 'pionhouder'motorConeHolder;
    // de dingen tussen hoge kommas moeten nog worden vervangen met de motornamen
    @Override
    public void init() {
        motorLeftBack = hardwareMap.dcMotor.get("linksachter");
        motorRightBack = hardwareMap.dcMotor.get("rechtsachter");
        motorLeftFront = hardwareMap.dcMotor.get("linksvoor");
        motorRightFront = hardwareMap.dcMotor.get("rechtsvoor");
        motorSlides = hardwareMap.dcMotor.get("slides");
        Grijp = hardwareMap.servo.get("Grijp");
        // motorGrabinator = hardwareMap.'armmotor'.get("armextender);
        // motorConeHolder = hardwareMap.'pionhouder'.get("mond");
        // de dingen tussen hoge kommas moeten nog worden vervangen met de motornamen
        servo = 0;

    }


    @Override
    public void start() {

    }


    @Override
    public void stop() {

    }

    @Override
    public void loop() {
        x = 0.5*gamepad1.left_stick_x;
        y = 0.5*gamepad1.left_stick_y;
        TurnRate = 0.5*(gamepad1.right_trigger - gamepad1.left_trigger);
        float z = gamepad2.right_trigger - gamepad2.left_trigger;
        if (gamepad2.a){
            Grijp.setPosition(1);
        }
        if (gamepad2.b){
            Grijp.setPosition(0);
        }

        motorRightBack.setPower(x - y + TurnRate);
        motorLeftBack.setPower(x + y + TurnRate);
        motorRightFront.setPower(-x + y + TurnRate);
        motorLeftFront.setPower(-x - y + TurnRate);
        motorSlides.setPower(z);
        // moet nog getest wordenm
    }
}
