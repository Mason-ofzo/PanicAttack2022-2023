package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.configuration.typecontainers.MotorConfigurationType;

import org.apache.commons.math3.stat.descriptive.rank.Max;
import org.apache.commons.math3.stat.descriptive.rank.Min;
import org.opencv.core.Mat;

@TeleOp
public class Testop extends OpMode {
    private DcMotor motorLeftFront;
    private DcMotor motorRightFront;
    private DcMotor motorLeftBack;
    private DcMotor motorRightBack;
    private double x;
    private double y;
    private int z;
    private double TurnRate;
    private DcMotor motorSlides;
    private Servo Grijp;
    float servo;

    @Override
    public void init() {
        motorLeftBack = hardwareMap.dcMotor.get("linksachter");
        motorRightBack = hardwareMap.dcMotor.get("rechtsachter");
        motorLeftFront = hardwareMap.dcMotor.get("linksvoor");
        motorRightFront = hardwareMap.dcMotor.get("rechtsvoor");
        motorSlides = hardwareMap.dcMotor.get("slides");
        motorSlides.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        motorSlides.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        Grijp = hardwareMap.servo.get("Grijp");
        servo = 0;
        z=0;

    }


    @Override
    public void start() {
        motorSlides.setTargetPosition(0);
        motorSlides.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }


    @Override
    public void stop() {

    }

    @Override
    public void loop() {
        x = 0.5*gamepad1.left_stick_x;
        y = 0.5*gamepad1.left_stick_y;
        TurnRate = 0.5*(gamepad1.right_trigger - gamepad1.left_trigger);
        if (gamepad2.dpad_up){
            z= -7600;
        }
        if (gamepad2.dpad_left){
            z=-6000;
        }
        if (gamepad2.dpad_right){
            z=-3800;
        }
        if (gamepad2.dpad_down){
            z = -1000;
        }
        z = z +Math.round(8*gamepad2.left_trigger)-Math.round(8*gamepad2.right_trigger);
        z = Math.max(-7600, z);
        z = Math.min(0, z);
        if (gamepad2.a){
            Grijp.setPosition(1);
        }
        if (gamepad2.b){
            Grijp.setPosition(0);
        }

        motorLeftFront.setPower(x - y + TurnRate);
        motorLeftBack.setPower(-x - y + TurnRate);
        motorRightFront.setPower(x + y + TurnRate);
        motorRightBack.setPower(-x + y + TurnRate);
        motorSlides.setPower(1);
        motorSlides.setTargetPosition(z);
        // moet nog getest worden
        telemetry.addData("liftmotor", motorSlides.getCurrentPosition());
        telemetry.addData("z",z);

    }
}
