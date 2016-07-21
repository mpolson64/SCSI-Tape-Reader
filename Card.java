public class Card implements OperationCard, NumberCard {
    private ArrayList<boolean> filteredScan;

    public Card(RawScan scan) {

    }

    public ArrayList<boolean> getScan() {
        return filteredScan;
    }

    public int binaryRead(ArrayList<boolean> list) {
        int number;
        for(int i = 0; i < list.size(); i++) {
            if(list.get(i)) {
                number += Math.pow(i, 2);
            } 
        }
        return number;
    }

    public byte getOperation() {    //0: add, 1:subtract, 2: multiply, 3: divide
        if (card.get(0) == false && card.get(1) == false){
            operation = 0;
        }
        else if (card.get(0) == false && card.get(1) == true){
            operation = 1;
        }
        else if (card.get(0) == true && card.get(1) == false){
            operation = 2;
        }
        else {
            operation = 3;
        }
    }

    public int getNumber() {
        return binaryRead(filteredScan);
    }

    public byte[] getNotes() {
        ArrayList<byte> temp0 = new ArrayList<byte>();

        for(int i = 0; i < filteredScan.size(); i += 2) {
            ArrayList<byte> temp1 = new ArrayList<byte>();
            for(int j = 0; j < 4; j++) {
                temp1.add(filteredScan.get(i));
            }
            temp0.add(binaryRead(temp1));
        }

        return temp0.toArray();
    }


}
