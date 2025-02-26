package recursion;

public class dectobin {

    public static void main(String[] args) {
        int decimalNumber = 13;
        System.out.println("Binary of " + decimalNumber + " is: " + toBinary(decimalNumber));
    }

    public static String toBinary(int decimal) {
        if (decimal == 0) {
            return "0";
        } else if (decimal == 1) {
            return "1";
        }

        return toBinary(decimal / 2) + (decimal % 2);
    }
}
