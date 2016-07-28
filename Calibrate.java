import java.io.File;
import java.io.*;

public class Calibrate extends Program {
	private File calibration;
	private PrintWriter writer;
	private RawScan raw;
	
	public Calibrate() {
		calibration = new File(".cal");
		writer = new PrintWriter(calibration);
		cards = new Card[1];
	}
	
	public void request() {
		raw = generateRawScan();
		cards[0] = new Card(raw);
	}
	
	public void run() {
		double[] chan0 = new double[2];
		double[] chan1 = new double[2];
		for(int i = 0; i < raw.getChan0().size(); i++) {
			if(i % 2 == 1) {
				chan0[0] += raw.getChan0().get(i);
				chan1[0] += raw.getChan1().get(i);
			}
			else {
				chan0[1] += raw.getChan0().get(i);
				chan1[1] += raw.getChan1().get(i);
			}
			
			chan0[0] = chan0[0] / raw.getChan0().size();
			chan1[0] = chan1[0] / raw.getChan1().size();
			chan0[1] = chan0[1] / raw.getChan0().size();
			chan1[1] = chan1[1] / raw.getChan1().size();
			
			writer.println((int)((chan0[0] + chan0[1]) / 2));
			writer.print((int)((chan1[0] + chan1[1]) / 2));
		}
	}
}