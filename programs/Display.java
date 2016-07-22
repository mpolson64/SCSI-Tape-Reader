package programs;

import lejos.util.*;

public class Display extends Program {
	
	public Display() {
		cards = new Card[1];
	}
	
	public void request() {
	    cards[0] = new Card(generateRawScan());	
	}
	
	public void run() {
	    LCD.drawString(card[0].toString(), 0, 0);	
	}
}
