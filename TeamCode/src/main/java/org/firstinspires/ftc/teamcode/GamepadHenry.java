package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp
public class GamepadHenry extends OpMode {
    @Override
    public void init(){
    }
    @Override
    public void loop(){
        telemetry.addData("Left Stick x", gamepad1.left_stick_x);
        telemetry.addData("Left stick y", gamepad1.left_stick_y);
        if(gamepad1.left_stick_y < 0){
            telemetry.addData("Left Stick y", "is negative");
        }
        if(gamepad1.left_stick_x < 0){
            telemetry.addData("Left Stick x", "is negative");
        }
        telemetry.addData("Right Stick x", gamepad1.right_stick_x);
        telemetry.addData("Right stick y", gamepad1.right_stick_y);
        telemetry.addData("A button", gamepad1.a);
        telemetry.addData("B button", gamepad1.b);
        telemetry.addData("Left Trigger",gamepad1.left_trigger);
        telemetry.addData("Right Trigger",gamepad1.right_trigger);
        telemetry.update();

        telemetry.addData("Difference between Left y and Right y",gamepad1.left_stick_y - gamepad1.right_stick_y);
        telemetry.addData("Sum of Left and Right Trigger",gamepad1.left_trigger + gamepad1.right_trigger);
    }
}
