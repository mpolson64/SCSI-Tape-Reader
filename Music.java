import lejos.nxt.LCD;

public class Music extends Program {
	MusicCard card;
	
    public Music() {
        cards = new Card[1];
    }

    public void request() {
		LCD.clear();
		LCD.drawString("CARD #1", 0, 0);
        cards[0] = new Card(generateRawScan());
		card = new MusicCard(cards[0]);
    }

    public void run() {
        LCD.clear();
		Integer x = new Integer(cards[0].getNumber());
		LCD.drawString(cards[0].toString(), 0, 0);
		LCD.drawString(x.toString(), 0, 1);
    }
}