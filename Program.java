import java.util.ArrayList;
import lejos.nxt.*;
import lejos.util.*;
import lejos.nxt.comm.*;

public abstract class Program {
	private final double CIRCUMFERENCE = 3.0 * Math.PI;	//cm
	private final double BOX_SIZE = 1.5;					//cm
	private final double SCAN_TIME = 1;					//sec
	
	private ColorSensor chan0;
	private LightSensor chan1;
	private TouchSensor scanButton;
	
    protected Card[] cards;

    public Program() {
        chan0 = new ColorSensor(SensorPort.S1);
		chan1 = new LightSensor(SensorPort.S2);
		scanButton = new TouchSensor(SensorPort.S3);
    }
	
	protected int[] read() {
		int[] temp = new int[2];
		
		Motor.A.setSpeed((int)(((360 * BOX_SIZE) / CIRCUMFERENCE) / SCAN_TIME));
		Motor.B.setSpeed((int)(((360 * BOX_SIZE) / CIRCUMFERENCE) / SCAN_TIME));
		
		Motor.A.forward();
		Motor.B.forward();
		
		Delay.msDelay((long)(SCAN_TIME * 1000));
		
		Motor.A.stop();
		Motor.B.stop();
		
		temp[0] = chan0.getLightValue();
		temp[1] = chan1.readValue();
		
		return temp;
	}
	
	protected RawScan generateRawScan() {
		ArrayList<Integer> chan0 = new ArrayList<Integer>(), chan1 = new ArrayList<Integer>();
		
		while(scanButton.isPressed()) {
			int[] temp = read();
			chan0.add(temp[0]);
			chan1.add(temp[1]);
		}
		RConsole.println("Size = " + chan0.size() + " " + chan1.size());
		return new RawScan(chan0, chan1);
	}
	
	public abstract void request();
    public abstract void run();
}
