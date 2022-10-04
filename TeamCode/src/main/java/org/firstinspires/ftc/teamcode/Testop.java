package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name = "Testop")
public class Testop extends OpMode {
    private DcMotor MotorFrontRight;
    private DcMotor MotorFrontLeft;
    private DcMotor MotorBackRight;
    private DcMotor MotorBackLeft;
    


    @Override
    public void init() {
        MotorBackLeft = hardwareMap.dcMotor.get("MotorBackLeft");
        MotorBackRight = hardwareMap.dcMotor.get("MotorBackRight");
        MotorFrontLeft = hardwareMap.dcMotor.get("MotorFrontLeft");
        MotorFrontRight = hardwareMap.dcMotor.get("MotorFrontRight")
    }

    @Override
    public void loop() {
        test1.setPower(gamepad1.left_stick_x);
        pos = pos + 0.001*gamepad1.right_stick_y;
        test2.setPosition(pos);
    }
}
