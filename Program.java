import lejos.nxt.*;
import lejos.util.*;

public abstract class Program {
    private Card card;

    public Program(Card card) {
        this.card = card;
    }

    public abstract void run();
}
