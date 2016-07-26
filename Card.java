import java.util.ArrayList;
import cards.*;

public class Card implements OperationCard, NumberCard, MacroCard, MusicCard {
    private ArrayList<Boolean> filteredScan;

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
			if(scan.getChan0().get(i) < mid0) {
				filteredScan.add(false);
			}
			else {
				filteredScan.add(true);
			}

			if(scan.getChan1().get(i) < mid1) {
				filteredScan.add(false);
			}
			else {
				filteredScan.add(true);
			}
        }
    }

    public ArrayList<Boolean> getScan() {
        return filteredScan;
    }

    public int binaryRead(ArrayList<Boolean> list) {
        int number = 0;
        for(int i = 0; i < list.size(); i++) {
            if(list.get(i)) {
                number += Math.pow(i, 2);
            } 
        }
        return number;
    }

    public byte getOperation() {    //0: add, 1:subtract, 2: multiply, 3: divide
        if (filteredScan.get(0) == false && filteredScan.get(1) == false){
            return 0;
        }
        else if (filteredScan.get(0) == false && filteredScan.get(1) == true){
            return 1;

        }
        else if (filteredScan.get(0) == true && filteredScan.get(1) == false){
            return 2;
        }
        else {
            return 3;
        }
    }

    public int getNumber() {
        return binaryRead(filteredScan);
    }

    public int getMacro() {
        return binaryRead(filteredScan);
    }


    public byte[] getNotes() {
        ArrayList<Byte> temp0 = new ArrayList<Byte>();

        for(int i = 0; i < filteredScan.size(); i += 2) {
            ArrayList<Boolean> temp1 = new ArrayList<Boolean>();
            for(int j = 0; j < 4; j++) {
                temp1.add(filteredScan.get(i));
            }
            temp0.add((byte)binaryRead(temp1));
        }

        byte[] out = new byte[filteredScan.size() / 2];


        for(int i = 0; i < out.length; i++) {
            out[i] = temp0.get(i);
        }

        return out;
    }

    public byte[] getTimings() {
        ArrayList<Byte> temp0 = new ArrayList<Byte>();

        for(int i = 1; i < filteredScan.size(); i += 2) {
            ArrayList<Boolean> temp1 = new ArrayList<Boolean>();
            for(int j = 0; j < 4; j++) {
                temp1.add(filteredScan.get(i));
            }
            temp0.add((byte)binaryRead(temp1));
        }

        byte[] out = new byte[filteredScan.size() / 2];

        for(int i = 0; i < out.length; i++) {
            out[i] = temp0.get(i);
        }

        return out;
    }

	public String toString() {
		String out = "";
		
		for(int i = 0; i < filteredScan.size(); i++) {
			if(filteredScan.get(i)) {
				out += "1";
			}
			else {
				out += "0";
			}
		}
		
		return out;
	}
}
