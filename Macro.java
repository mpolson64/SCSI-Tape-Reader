import lejos.nxt.LCD;
import java.awt.*;
import java.awt.event.*;

public class Display extends Program {
	private int macro;
	
	private Robot bot;
	
    public Display() {
		bot = new Robot;
        cards = new Card[1];
    }

    public void request() {
		LCD.clear();
		LCD.drawString("CARD #1", 0, 0);
        cards[0] = new Card(generateRawScan());
		
		MacroCard macroCard = cards[0];
		macro = macroCard.getMacro();
    }

    public void run() {
        LCD.clear();
		Integer x = new Integer(cards[0].getNumber());
		LCD.drawString(cards[0].toString(), 0, 0);
		LCD.drawString(x.toString(), 0, 1);
    }
	
	private void type(String string) throws AWTException{
		for(char c : string.toLowerCase().toCharArray()) {
			type(c);
		}
	}
	
	private void type(char character) throws AWTException{
		switch (character) {
			case 'a': 
				bot.keyPress(KeyEvent.VK_A);
				bot.keyRelease(KeyEvent.VK_A);
				break;
			case 'b': 
				bot.keyPress(KeyEvent.VK_B);
				bot.keyRelease(KeyEvent.VK_B);
				break;
			case 'c': 
				bot.keyPress(KeyEvent.VK_C);
				bot.keyRelease(KeyEvent.VK_C);
				break;
			case 'd': 
				bot.keyPress(KeyEvent.VK_D);
				bot.keyRelease(KeyEvent.VK_D);
				break;
			case 'e': 
				bot.keyPress(KeyEvent.VK_E);
				bot.keyRelease(KeyEvent.VK_E);
				break;
			case 'f': 
				bot.keyPress(KeyEvent.VK_F);
				bot.keyRelease(KeyEvent.VK_F);
				break;
			case 'g': 
				bot.keyPress(KeyEvent.VK_G);
				bot.keyRelease(KeyEvent.VK_G);
				break;
			case 'h': 
				bot.keyPress(KeyEvent.VK_H);
				bot.keyRelease(KeyEvent.VK_H);
				break;
			case 'i': 
				bot.keyPress(KeyEvent.VK_I);
				bot.keyRelease(KeyEvent.VK_I);
				break;
			case 'j': 
				bot.keyPress(KeyEvent.VK_J);
				bot.keyRelease(KeyEvent.VK_J);
				break;
			case 'k': 
				bot.keyPress(KeyEvent.VK_K);
				bot.keyRelease(KeyEvent.VK_K);
				break;
			case 'l': 
				bot.keyPress(KeyEvent.VK_L);
				bot.keyRelease(KeyEvent.VK_L);
				break;
			case 'm': 
				bot.keyPress(KeyEvent.VK_M);
				bot.keyRelease(KeyEvent.VK_M);
				break;
			case 'n': 
				bot.keyPress(KeyEvent.VK_N);
				bot.keyRelease(KeyEvent.VK_N);
				break;
			case 'o': 
				bot.keyPress(KeyEvent.VK_O);
				bot.keyRelease(KeyEvent.VK_O);
				break;
			case 'p': 
				bot.keyPress(KeyEvent.VK_P);
				bot.keyRelease(KeyEvent.VK_P);
				break;
			case 'q': 
				bot.keyPress(KeyEvent.VK_Q);
				bot.keyRelease(KeyEvent.VK_Q);
				break;
			case 'r': 
				bot.keyPress(KeyEvent.VK_R);
				bot.keyRelease(KeyEvent.VK_R);
				break;
			case 's': 
				bot.keyPress(KeyEvent.VK_S);
				bot.keyRelease(KeyEvent.VK_S);
				break;
			case 't': 
				bot.keyPress(KeyEvent.VK_T);
				bot.keyRelease(KeyEvent.VK_T);
				break;
			case 'u': 
				bot.keyPress(KeyEvent.VK_U);
				bot.keyRelease(KeyEvent.VK_U);
				break;
			case 'v': 
				bot.keyPress(KeyEvent.VK_V);
				bot.keyRelease(KeyEvent.VK_V);
				break;
			case 'w': 
				bot.keyPress(KeyEvent.VK_W);
				bot.keyRelease(KeyEvent.VK_W);
				break;
			case 'x': 
				bot.keyPress(KeyEvent.VK_X);
				bot.keyRelease(KeyEvent.VK_X);
				break;
			case 'y': 
				bot.keyPress(KeyEvent.VK_Y);
				bot.keyRelease(KeyEvent.VK_Y);
				break;
			case 'z': 
				bot.keyPress(KeyEvent.VK_Z);
				bot.keyRelease(KeyEvent.VK_Z);
				break;
			case '0': 
				bot.keyPress(KeyEvent.VK_0);
				bot.keyRelease(KeyEvent.VK_0);
				break;
			case '1': 
				bot.keyPress(KeyEvent.VK_1);
				bot.keyRelease(KeyEvent.VK_1);
				break;
			case '2': 
				bot.keyPress(KeyEvent.VK_2);
				bot.keyRelease(KeyEvent.VK_2);
				break;
			case '3': 
				bot.keyPress(KeyEvent.VK_3);
				bot.keyRelease(KeyEvent.VK_3);
				break;
			case '4': 
				bot.keyPress(KeyEvent.VK_4);
				bot.keyRelease(KeyEvent.VK_4);
				break;
			case '5': 
				bot.keyPress(KeyEvent.VK_5);
				bot.keyRelease(KeyEvent.VK_5);
				break;
			case '6': 
				bot.keyPress(KeyEvent.VK_6);
				bot.keyRelease(KeyEvent.VK_6);
				break;
			case '7': 
				bot.keyPress(KeyEvent.VK_7);
				bot.keyRelease(KeyEvent.VK_7);
				break;
			case '8': 
				bot.keyPress(KeyEvent.VK_8);
				bot.keyRelease(KeyEvent.VK_8);
				break;
			case '9': 
				bot.keyPress(KeyEvent.VK_9);
				bot.keyRelease(KeyEvent.VK_9);
				break;
			
			case '/': 
				bot.keyPress(KeyEvent.VK_SLASH); 
				bot.keyRelease(KeyEvent.VK_SLASH);
				break;
			case '.': 
				bot.keyPress(KeyEvent.VK_PERIOD); 
				bot.keyRelease(KeyEvent.VK_PERIOD);
				break;
		}
	}
}