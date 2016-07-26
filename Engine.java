import java.util.ArrayList;

import lejos.nxt.*;
import lejos.util.*;
import lejos.nxt.comm.*;

public class Engine {	
	private static TouchSensor feedButton = new TouchSensor(SensorPort.S4);
	private static TouchSensor scanButton = new TouchSensor(SensorPort.S3);
	
	private static String state = "IDLE";	//IDLE, SCANNING
	
	private static Card lastCard = null;
	
	public static void main(String[] args) {
		RConsole.open();
		RConsole.println("Hello from robot");
		while (true){
			switch(state) {
				case "IDLE":
					idle();
					break;
				case "FEEDING":
					feed();
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
	
	private static void feed() {
		Motor.A.setSpeed(180);
		Motor.B.setSpeed(180);
		
		Motor.A.forward();
		Motor.B.forward();
		
		if(!feedButton.isPressed()) {
			state = "IDLE";
		}
	}
	
	private static void display() {
		Program display = new Display();
		display.request();
		display.run();
		
		state = "IDLE";
	}
	
	private static void idle() {
		Motor.A.setSpeed(0);
		Motor.B.setSpeed(0);
		
		if (scanButton.isPressed()){
			state = "DISPLAY";
		}
		else if (feedButton.isPressed()){
			state = "FEEDING";
		}
	}
}