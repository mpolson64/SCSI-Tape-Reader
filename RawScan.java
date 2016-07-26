import java.util.ArrayList;

public class RawScan {
    private ArrayList < Integer > chan0, chan1;

    public RawScan(ArrayList < Integer > chan0, ArrayList < Integer > chan1) {
        this.chan0 = chan0;
        this.chan1 = chan1;
    }

    public ArrayList < Integer > getChan0() {
        return chan0;
    }

    public ArrayList < Integer > getChan1() {
        return chan1;
    }
}