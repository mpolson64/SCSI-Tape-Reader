import java.util.ArrayList;

import lejos.nxt.comm.RConsole;
import lejos.nxt.Button;
import lejos.nxt.LCD;
import lejos.nxt.Motor;
import lejos.nxt.SensorPort;
import lejos.nxt.TouchSensor;

import lejos.util.Delay;

public class Engine {
    private static TouchSensor feedButton = new TouchSensor(SensorPort.S4);
    private static TouchSensor scanButton = new TouchSensor(SensorPort.S3);

    private static String state = "MENU"; //IDLE, MENU, DISPLAY

    private static Card lastCard = null;

    public static void main(String[] args) {
        RConsole.open();
        RConsole.println("Comms open");
        while (true) {
            switch (state) {
                case "IDLE":
                    idle();
                    break;
                case "MENU":
                    menu();
                    break;
                case "DISPLAY":
                    display();
                    break;
                default:
                    break;
            }
            Delay.msDelay(20);
        }
    }

    private static void display() {
        Program display = new Display();
        display.request();
        display.run();

        state = "MENU";
		
		while (!Button.ENTER.isDown());
    }

    private static void idle() {
        Motor.A.setSpeed(0);
        Motor.B.setSpeed(0);
    }

    private static void menu() {
        String[] modes = {
            "DISPLAY"
        };
        int selected = 0;

        LCD.clear();
        LCD.drawString(modes[selected], 0, 3);

        if (Button.RIGHT.isDown()) {
            selected += 1;
        } else if (Button.LEFT.isDown()) {
            selected -= 1;
        }
        if (selected < 0) {
            selected = modes.length - 1;
        } else if (selected == modes.length) {
            selected = 0;
        }

        if (Button.ENTER.isDown()) {
            state = modes[selected];
        }
    }
}