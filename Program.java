import java.util.ArrayList;
import lejos.nxt.*;
import lejos.util.*;
import lejos.nxt.comm.*;

public abstract class Program {
	private final double CIRCUMFERENCE = 3.0 * Math.PI;	//cm
	private final double BOX_SIZE = 1.5;				//cm
	private final double SCAN_TIME = 1;					//sec

	private LightSensor chan0, chan1;
	private TouchSensor scanButton;
	
	private ArrayList<Integer> read0, read1;
	
    protected Card[] cards;

    public Program() {
		RConsole.println("Begin Program constructor");
        chan0 = new LightSensor(SensorPort.S1);
		chan1 = new LightSensor(SensorPort.S2);
		scanButton = new TouchSensor(SensorPort.S3);
		
		read0 = new ArrayList<Integer>();
		read1 = new ArrayList<Integer>();
    }
	
	protected int[] read() {
		int[] temp = new int[2];
		
		temp[0] = chan0.getLightValue();
		temp[1] = chan1.readValue();
		
		Motor.A.setSpeed((int)(((360 * BOX_SIZE) / CIRCUMFERENCE) / SCAN_TIME));
		Motor.B.setSpeed((int)(((360 * BOX_SIZE) / CIRCUMFERENCE) / SCAN_TIME));
		
		Motor.A.forward();
		Motor.B.forward();
		
		Delay.msDelay((long)(SCAN_TIME * 1000));
		
		Motor.A.stop();
		Motor.B.stop();
		
		return temp;
	}
	
	protected RawScan generateRawScan() {
		RConsole.println("Begin generateRawScan()");
		
		while(scanButton.isPressed()) {
			int[] temp = read();
			read0.add(temp[0]);
			read1.add(temp[1]);
		}
		RConsole.println("Size = " + read0.size() + " " + read1.size());
		return new RawScan(read0, read1);
	}
	
	public abstract void request();
    public abstract void run();
}
