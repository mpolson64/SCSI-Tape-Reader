import java.util.ArrayList;

import lejos.nxt.LightSensor;
import lejos.nxt.Motor;
import lejos.nxt.TouchSensor;
import lejos.nxt.SensorPort;
import lejos.nxt.LCD;

import lejos.util.Delay;

public abstract class Program {
    private final double CIRCUMFERENCE = 3.0 * Math.PI; //cm
    private final double BOX_SIZE = 1.5; 				//cm
    private final double SCAN_TIME = 0.5; 				//sec

    private LightSensor chan0, chan1;
    private TouchSensor scanButton, feedButton;

    private ArrayList < Integer > read0, read1;

    protected Card[] cards;

    public Program() {
        chan0 = new LightSensor(SensorPort.S1);
        chan1 = new LightSensor(SensorPort.S2);
        scanButton = new TouchSensor(SensorPort.S3);
        feedButton = new TouchSensor(SensorPort.S4);

        read0 = new ArrayList < Integer > ();
        read1 = new ArrayList < Integer > ();
    }

    private void feed() {
        Motor.A.setSpeed(180);
        Motor.B.setSpeed(180);

        Motor.A.forward();
        Motor.B.forward();
    }

    private void stop() {
        Motor.A.stop();
        Motor.B.stop();
    }

    private int[] read() {
        int[] temp = new int[2];

        temp[0] = chan0.readValue();
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
		read0.clear();
		read1.clear();
		
        while (!feedButton.isPressed()); //Wait until feed button is pressed before continuing

        while (!scanButton.isPressed()) {
            if (feedButton.isPressed()) {
                feed();
            } else {
                stop();
            }
        }

        while (scanButton.isPressed()) {
            int[] temp = read();
            read0.add(temp[0]);
            read1.add(temp[1]);
        }

		return new RawScan(read0, read1);
    }

    public abstract void request();

    public abstract void run();
}