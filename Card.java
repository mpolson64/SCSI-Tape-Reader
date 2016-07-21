import java.util.ArrayList;

public class Card implements OperationCard, NumberCard, MacroCard, MusicCard {
    private ArrayList<Boolean> filteredScan;

    public Card(RawScan scan) {

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


}
