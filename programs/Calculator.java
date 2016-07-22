package programs;

public class Calculator extends Program {
	private int number0, number1;
	private byte operation;
	
	public Calculator() {
		cards = new Card[3];
	}
	
	public void request() {
		//TODO: Reqest cards
		
		NumberCard numberCard0 = cards[0], numberCard1 = cards[1];
		OperationCard opCard = cards[3];
		
		number0 = numberCard0.getNumber();
		number1 = numberCard1.getNumber();
		operation = opCard.getOperation();
	}
	
	public void run() {
		int result;
		if(operation == 0) {
			result = number0 + number1;
		}
		else if(operation == 1) {
			result = number0 - number1;
		}
		else if(operation == 2) {
			result = number0 * number1;
		}
		else {
			result = number0 / number1;
		}
		
	}
}