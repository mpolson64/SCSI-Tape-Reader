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

    private static String state = "MENU"; //IDLE, MENU, DISPLAY, CALCULATOR
	private static int selected = 0;
	
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
				case "CALCULATOR":
					calculator();
					break;
				case "MUSIC":
					music();
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

		while (!Button.ENTER.isDown());
        state = "MENU";
		while (Button.ENTER.isDown());
    }

	private static void calculator() {
		Program calculator = new Calculator();
		calculator.request();
		calculator.run();
		
		while (!Button.ENTER.isDown());
        state = "MENU";
		while (Button.ENTER.isDown());
	}
	
	private static void music() {
		Program music = new Music();
		music.request();
		music.run();
		
		while (!Button.ENTER.isDown());
        state = "MENU";
		while (Button.ENTER.isDown());
	}
	
    private static void idle() {
        Motor.A.setSpeed(0);
        Motor.B.setSpeed(0);
    }

    private static void menu() {
        String[] modes = {
            "DISPLAY",
			"CALCULATOR",
			"MUSIC"
        };

        LCD.clear();
        LCD.drawString(modes[selected], 0, 3);

        if (Button.RIGHT.isDown()) {
            selected += 1;
			while (Button.RIGHT.isDown());
        } else if (Button.LEFT.isDown()) {
            selected -= 1;
			while (Button.RIGHT.isDown());
        }
        if (selected < 0) {
            selected = modes.length - 1;
			while (Button.RIGHT.isDown());
        } else if (selected == modes.length) {
            selected = 0;
			while (Button.RIGHT.isDown());
        }

        if (Button.ENTER.isDown()) {
            state = modes[selected];
        }
    }
}