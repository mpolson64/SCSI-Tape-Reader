import java.util.ArrayList;
import lejos.nxt.LCD;

public class Card implements OperationCard, NumberCard, MacroCard, MusicCard {
    private ArrayList <Boolean> filteredScan;

    public Card(RawScan scan) {
        filteredScan = new ArrayList<Boolean>();

        int sum0 = 0;
        for(int i = 0; i < scan.getChan0().size(); i++) {
            sum0 += scan.getChan0().get(i);
        }
        int sum1 = 0;
        for(int i = 0; i < scan.getChan1().size(); i++) {
            sum1 += scan.getChan1().get(i);
        }

        int mid0 = sum0 / scan.getChan0().size();
        int mid1 = sum1 / scan.getChan1().size();

        for(int i = 0; i < scan.getChan0().size(); i++) {
            if (scan.getChan0().get(i) > mid0) {
                filteredScan.add(0, false);
            }
            else {
                filteredScan.add(0, true);
            }
            LCD.clear();

            if (scan.getChan1().get(i) > mid1) {
                filteredScan.add(0, false);
            }
            else {
                filteredScan.add(0, true);
            }
            LCD.clear();
        }
    }

    public int binaryRead(ArrayList < Boolean > list) {
        int number = 0;
        for (int i = 0; i < filteredScan.size(); i++) {
            if (list.get(i)) {
                number += Math.pow(2, filteredScan.size() - 1 - i);
            }
        }
        return number;
    }

    public byte getOperation() { //0: add, 1:subtract, 2: multiply, 3: divide
        if (filteredScan.get(filteredScan.size() - 1) == false && filteredScan.get(filteredScan.size() - 2) == false) {
            return 0;
        } else if (filteredScan.get(filteredScan.size() - 1) == false && filteredScan.get(filteredScan.size() - 2) == true) {
            return 1;
        } else if (filteredScan.get(filteredScan.size() - 1) == true && filteredScan.get(filteredScan.size() - 2) == false) {
            return 2;
        } else {
            return 3;
        }
    }

    public int getNumber() {
        return binaryRead(filteredScan);
    }

    public int getMacro() {
        filteredScan.removeRange(4, filteredScan.size());
        return binaryRead(filteredScan);
    }


    public byte[] getNotes() {
        ArrayList < Byte > temp0 = new ArrayList < Byte > ();

        for (int i = 0; i < filteredScan.size(); i += 2) {
            ArrayList < Boolean > temp1 = new ArrayList < Boolean > ();
            for (int j = 0; j < 4; j++) {
                temp1.add(filteredScan.get(i));
            }
            temp0.add((byte) binaryRead(temp1));
        }

        byte[] out = new byte[filteredScan.size() / 2];

        for (int i = 0; i < out.length; i++) {
            out[i] = temp0.get(i);
        }

        return out;
    }

    public byte[] getTimings() {
        ArrayList < Byte > temp0 = new ArrayList < Byte > ();

        for (int i = 1; i < filteredScan.size(); i += 2) {
            ArrayList < Boolean > temp1 = new ArrayList < Boolean > ();
            for (int j = 0; j < 4; j++) {
                temp1.add(filteredScan.get(i));
            }
            temp0.add((byte) binaryRead(temp1));
        }

        byte[] out = new byte[filteredScan.size() / 2];

        for (int i = 0; i < out.length; i++) {
            out[i] = temp0.get(i);
        }

        return out;
    }

    public String toString() {
        String out = new String();

        for (int i = 0; i < filteredScan.size(); i++) {
            if (filteredScan.get(i)) {
                out += "1";
            } else {
                out += "0";
            }
        }

        return out;
    }
}
