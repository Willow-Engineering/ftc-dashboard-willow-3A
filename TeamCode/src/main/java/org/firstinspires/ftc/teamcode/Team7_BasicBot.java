package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;
@TeleOp(name="Team7_BasicBot")
//@Disabled
public class Team7_BasicBot extends LinearOpMode {

    //    // Declare OpMode members.
    private ElapsedTime runtime = new ElapsedTime();
    private DcMotor leftDrive = null;
    private DcMotor rightDrive = null;
    private DcMotorEx armMotor = null;
    private Servo leftServo = null;
    private Servo rightServo = null;
    //
    @Override
    public void runOpMode() {
        telemetry.addData("Status", "Initialized");
        telemetry.update();
//
//        // Initialize the hardware variables. Note that the strings used here as parameters
//        // to 'get' must correspond to the names assigned during the robot configuration
//        // step (using the FTC Robot Controller app on the phone).
        leftDrive  = hardwareMap.get(DcMotor.class, "left_drive");
        rightDrive = hardwareMap.get(DcMotor.class, "right_drive");
        armMotor = hardwareMap.get(DcMotorEx.class, "arm_motor");
        leftServo = hardwareMap.get(Servo.class, "left_servo");
        rightServo = hardwareMap.get(Servo.class, "right_servo");
//
//        // To drive forward, most robots need the motor on one side to be reversed, because the axles point in opposite directions.
//        // Pushing the left stick forward MUST make robot go forward. So adjust these two lines based on your first test drive.
//        // Note: The settings here assume direct drive on left and right wheels.  Gear Reduction or 90 Deg drives may require direction flips
//        leftDrive.setDirection(DcMotor.Direction.REVERSE);
//        rightDrive.setDirection(DcMotor.Direction.FORWARD);
//
//        // Wait for the game to start (driver presses PLAY)
        waitForStart();
        runtime.reset();
        armMotor.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);

//
//        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {
//
//            // Setup a variable for each drive wheel to save power level for telemetry
            double leftPower;
            double rightPower;
//
//            // Choose to drive using either Tank Mode, or POV Mode
//            // Comment out the method that's not used.  The default below is POV.
//
//            // POV Mode uses left stick to go forward, and right stick to turn.
//            // - This uses basic math to combine motions and is easier to drive straight.
            double drive = -gamepad1.left_stick_y;
            double turn  =  gamepad1.right_stick_x;
            leftPower    = Range.clip(drive + turn, -1.0, 1.0) ;
            rightPower   = Range.clip(drive - turn, -1.0, 1.0) ;
//
//            // Tank Mode uses one stick to control each wheel.
//            // - This requires no math, but it is hard to drive forward slowly and keep straight.
            leftPower  = -gamepad1.left_stick_y ;
            rightPower = -gamepad1.right_stick_y ;
//
//            // Send calculated power to wheels
            leftDrive.setPower(leftPower);
            rightDrive.setPower(rightPower);
//
            // if(gamepad1.dpad_up){
            //     armMotor.setPower(0.7);
            // }else{
            //     armMotor.setPower(0.0);
            // }
            // if(gamepad1.dpad_down){
            //     armMotor.setPower(-0.4);
            // }else{
            //     armMotor.setPower(0.0);
            //}
//            if (gamepad1.left_trigger) {
//                rightServo.setPosition(30);
//                leftServo.setPosition(-30);
//            }
//            if (gamepad1.right_trigger) {
//                rightServo.setPosition(-30);
//                leftServo.setPosition(30);
//            }
            //Limit Switch
            //if (touch.getState()){
            //    //Touch Sensor is not pressed
            //     arm.setPower(0.2);
            //
            //} else {
            //    //Touch Sensor is pressed
            //    arm.setPower(0);
            //                        }

            //Encoder
            telemetry.addData("Encoder value", armMotor.getCurrentPosition());
            if(gamepad1.dpad_up){
                // Set the motor's target position to 300 ticks
                armMotor.setTargetPosition(300);

                // Switch to RUN_TO_POSITION mode
                armMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);

                // Start the motor moving by setting the max velocity to 200 ticks per second
                armMotor.setVelocity(200);
            }
            if(gamepad1.dpad_down){
                // Set the motor's target position to 300 ticks
                armMotor.setTargetPosition(0);

                // Switch to RUN_TO_POSITION mode
                armMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);

                // Start the motor moving by setting the max velocity to 200 ticks per second
                armMotor.setVelocity(200);
            }


            // Show the elapsed game time and wheel power.
            telemetry.addData("Status", "Run Time: " + runtime.toString());
            telemetry.addData("Motors", "left (%.2f), right (%.2f)", leftPower, rightPower);
            telemetry.update();
        }

    }
}
