import lejos.nxt.*;
import lejos.util.*;

public class Music extends Program {
    private const int MILLISECONDS_PER_THIRTYSECOND = 250;

    private MusicCard card;

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
        switch(note) {
            case 0:
                Sound.playTone((440, (int)(MILLISECONDS_PER_THIRTYSECOND * (time + 1));
                break;
            case 1:
                Sound.playTone((466, (int)(MILLISECONDS_PER_THIRTYSECOND * (time + 1));
                break;
            case 2:
                Sound.playTone((494, (int)(MILLISECONDS_PER_THIRTYSECOND * (time + 1));
                break;
            case 3:
                Sound.playTone((523, (int)(MILLISECONDS_PER_THIRTYSECOND * (time + 1));
                break;
            case 4:
                Sound.playTone((554, (int)(MILLISECONDS_PER_THIRTYSECOND * (time + 1));
                break;
            case 5:
                Sound.playTone((587, (int)(MILLISECONDS_PER_THIRTYSECOND * (time + 1));
                break;
            case 6:
                Sound.playTone((622, (int)(MILLISECONDS_PER_THIRTYSECOND * (time + 1));
                break;
            case 7:
                Sound.playTone((659, (int)(MILLISECONDS_PER_THIRTYSECOND * (time + 1));
                break;
            case 8:
                Sound.playTone((698, (int)(MILLISECONDS_PER_THIRTYSECOND * (time + 1));
                break;
            case 9:
                Sound.playTone((740, (int)(MILLISECONDS_PER_THIRTYSECOND * (time + 1));
                break;
            case 10:
                Sound.playTone((784, (int)(MILLISECONDS_PER_THIRTYSECOND * (time + 1));
                break;
            case 11:
                Sound.playTone((831, (int)(MILLISECONDS_PER_THIRTYSECOND * (time + 1));
                break;
            case 12:
                Sound.playTone((880, (int)(MILLISECONDS_PER_THIRTYSECOND * (time + 1));
                break;
            case 13:
                Sound.playTone((932, (int)(MILLISECONDS_PER_THIRTYSECOND * (time + 1));
                break;
            case 14:
                Sound.playTone((988, (int)(MILLISECONDS_PER_THIRTYSECOND * (time + 1));
                break;
            case 15:
                Sound.playTone((1047, (int)(MILLISECONDS_PER_THIRTYSECOND * (time + 1));
                break;
        }

        Delay.msDelay((int)(MILLISECONDS_PER_THIRTYSECOND * (time + 1)));
    }
}
