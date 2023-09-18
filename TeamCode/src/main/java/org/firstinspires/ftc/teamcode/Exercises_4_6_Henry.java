package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp
public class Exercises_4_6_Henry extends OpMode {
    private DcMotor Motor1;

    @Override
    public void init() {
        telemetry.addData("Left Stick x", gamepad1.left_stick_x);
        telemetry.addData("Left stick y", gamepad1.left_stick_y);
        Motor1  = hardwareMap.get(DcMotor.class, "Motor1");
    }

    @Override
    public void loop() {

        double fwdSpeed = gamepad1.left_stick_y;
        double ySpeed = gamepad1.left_stick_y;
        double xSpeed = gamepad1.left_stick_x;


        if (gamepad1.a) { //turbo
            fwdSpeed *= 0.5;
        }
        if (!gamepad1.a) { //turbo
            fwdSpeed *= 1;
        }

        if (!gamepad1.a) { //crazy mode
            ySpeed = gamepad1.left_stick_x;
            xSpeed = gamepad1.left_stick_y;
        }

        if (gamepad1.b) {//run motor 1
            Motor1.setPower(1);
        }
    }
}
