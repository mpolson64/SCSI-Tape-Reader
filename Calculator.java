import lejos.nxt.LCD;

public class Calculator extends Program {
	private int number0, number1;
	private byte operation;
	
	public Calculator() {
		cards = new Card[3];
	}
	
	public void request() {
		LCD.clear();
		LCD.drawString("NUMBER CARD #1", 0, 0);
		cards[0] = new Card(generateRawScan());
		LCD.drawString((new Integer(cards[0].getNumber())).toString(), 0, 1);
		LCD.drawString("NUMBER CARD #2", 0, 0);
		cards[1] = new Card(generateRawScan());
		LCD.drawString((new Integer(cards[1].getNumber())).toString(), 0, 2);
		LCD.drawString("OPERATION CARD", 0, 0);
		cards[2] = new Card(generateRawScan());
		
		NumberCard numberCard0 = cards[0], numberCard1 = cards[1];
		OperationCard opCard = cards[2];
		
		number0 = numberCard0.getNumber();
		number1 = numberCard1.getNumber();
		operation = opCard.getOperation();
	}
	
	public void run() {
		double result;
		String equation;
		if (operation == 0) {
			result = number0 + number1;
			equation = number0 + " + " + number1;
			
		}
		else if (operation == 1) {
			result = number0 - number1;
			equation = number0 + " - " + number1;
		}
		else if (operation == 2) {
			result = number0 * number1;
			equation = number0 + " * " + number1;
		}
		else {
			result = (double)number0 / number1;
			equation = number0 + " / " + number1;
		}
		
		LCD.drawString(equation, 0, 0);
		LCD.drawString((new Double(result)).toString(), 0, 2);
	}
}