package org.firstinspires.ftc.teamcode;
import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.telemetry;

import com.qualcomm.robotcore.eventloop.opmode.Teleop;

@Teleop()
public class HelloWorldHenry {
    @Override
    public void init(){
        telemetry.addData("Hello","World");

    }

    @Override
    public void loop() {
    }
}
