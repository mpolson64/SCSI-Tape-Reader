import lejos.nxt.LCD;
import lejos.util.*;

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
        System.out.println(card.getNotes());
        Delay.msDelay(2000);
    }

    private void playNote(byte note, byte time) {
    }
}
