import lejos.nxt.*;
import lejos.util.*;

public abstract class Program {
    protected Card[] cards;

    public Program() {
        
    }
	
	public abstract void request();
    public abstract void run();
}
