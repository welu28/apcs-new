public class useBase {
    
    private static int binaryToDecimal(String binary) {
        int res = 0;
        int n = binary.length();
        for (int i = 0; i < n; i++) {
            char bit = binary.charAt(n - 1 - i);
            if (bit == '1') res += Math.pow(2, i);
        }
        return res;
    }
    
    private static int hexToDecimal(String hex) {
        int res = 0;
        int n = hex.length();
        for (int i = 0; i < n; i++) {
            char hexDigit = hex.charAt(n - 1 - i);
            int value;
            if (hexDigit >= '0' && hexDigit <= '9') value = hexDigit - '0';
            else value = 10 + (hexDigit - 'A');
            res += value * Math.pow(16, i);
        }
        return res;
    }
    
    private static String decimalToBinary(int decimal) {
        StringBuilder binary = new StringBuilder();
        while (decimal > 0) {
            binary.append(decimal % 2);
            decimal /= 2;
        }
        return binary.reverse().toString();
    }
    
    private static String decimalToHex(int decimal) {
        StringBuilder hex = new StringBuilder();
        while (decimal > 0) {
            int remainder = decimal % 16;
            if (remainder < 10) hex.append((char) ('0' + remainder));
            else hex.append((char) ('A' + (remainder - 10)));
            decimal /= 16;
        }
        return hex.reverse().toString();
    }
    
    public static String add(String num1, String num2, String base) {
        int decimal1 = convertToDecimal(num1, base);
        int decimal2 = convertToDecimal(num2, base);
        int result = decimal1 + decimal2;
        return convertFromDecimal(result, base);
    }
    
    public static String subtract(String num1, String num2, String base) {
        int decimal1 = convertToDecimal(num1, base);
        int decimal2 = convertToDecimal(num2, base);
        int result = decimal1 - decimal2;
        return convertFromDecimal(result, base);
    }
    
    public static String multiply(String num1, String num2, String base) {
        int decimal1 = convertToDecimal(num1, base);
        int decimal2 = convertToDecimal(num2, base);
        int result = decimal1 * decimal2;
        return convertFromDecimal(result, base);
    }
    
    public static String divide(String num1, String num2, String base) {
        int decimal1 = convertToDecimal(num1, base);
        int decimal2 = convertToDecimal(num2, base);
        if (decimal2 == 0) throw new ArithmeticException("can't divide by zero");
        int result = decimal1 / decimal2;
        return convertFromDecimal(result, base);
    }
    
    private static int convertToDecimal(String num, String base) {
        switch (base.toLowerCase()) {
            case "binary":
                return binaryToDecimal(num);
            case "hex":
                return hexToDecimal(num);
            case "decimal":
                return Integer.parseInt(num); 
            default:
                throw new IllegalArgumentException();
        }
    }
    
    private static String convertFromDecimal(int num, String base) {
        switch (base.toLowerCase()) {
            case "binary":
                return decimalToBinary(num);
            case "hex":
                return decimalToHex(num);
            case "decimal":
                return Integer.toString(num); 
            default:
                throw new IllegalArgumentException();
        }
    }

    public static String convert(String num, String from, String to) {
        int val = convertToDecimal(num, from);
        return convertFromDecimal(val, to);
    }
    
    public static void main(String[] args) {
        System.out.println(add("1010", "110", "binary"));
        System.out.println(add("A", "F", "hex"));
        System.out.println(subtract("50", "20", "decimal")); 
        System.out.println(convert("1010", "binary", "hex")); 
        System.out.println(multiply("A", "B", "hex"));
    }
}
