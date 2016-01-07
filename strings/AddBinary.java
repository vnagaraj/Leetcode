package strings;

/**
 * Created by VGN on 1/7/16.
 */
public class AddBinary {

    /*
    Given two binary strings, return their sum (also a binary string).
    For example,
    a = "11"
    b = "1"
    Return "100".
     */
    public String addBinary(String a, String b) {
        String result = "";
        if (a.length() < b.length()){
            int diff = b.length() - a.length();
            for (int i=0; i < diff; i++){
                a = "0" + a;
            }
        }
        else if (b.length() < a.length()){
            int diff = a.length() - b.length();
            for (int i=0; i < diff; i++){
                b = "0" + b;
            }
        }
        String totSum = "";
        char carryOver = '0';
        //String a and b are equal
        for (int i= a.length()-1; i >=0; i--){
            char x = a.charAt(i);
            char y = b.charAt(i);
            String sum = "";
            if (x == '1' && y == '1' && carryOver == '0'){
                sum = "0";
                carryOver = '1';
            }
            else if (x == '1' && y == '1' && carryOver == '1'){
                sum = "1";
                carryOver = '1';
            }
            else if ((x == '1' && y == '0' || x == '0' && y == '1') && carryOver == '0'){
                sum = "1";
                carryOver = '0';
            }
            else if ((x == '1' && y == '0' || x == '0' && y == '1') && carryOver == '1'){
                sum = "0";
                carryOver = '1';
            }
            else if (x == '0' && y == '0' && carryOver == '1'){
                sum = "1";
                carryOver = '0';
            }
            else if (x == '0' && y == '0' && carryOver == '0'){
                sum = "0";
                carryOver = '0';
            }
            totSum =sum + totSum;
        }
        if (carryOver != '0'){
            totSum = carryOver + totSum;
        }
        return  totSum;
    }

    public static void main(String[] args){
        AddBinary binary = new AddBinary();
        String a = "1111";
        String b = "1111";
        System.out.println(binary.addBinary(a, b));
    }
}
