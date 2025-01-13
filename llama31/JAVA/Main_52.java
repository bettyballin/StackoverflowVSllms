import java.lang.String;
public class Main_52 {
    public static void main(String[] args) {
        System.out.println(decimalToColumn(0));  // A
        System.out.println(decimalToColumn(25)); // Z
        System.out.println(decimalToColumn(26)); // AA
        System.out.println(decimalToColumn(702)); // AAA
    }

    public static String decimalToColumn(int decimal) {
        StringBuilder column = new StringBuilder();
        while (decimal >= 0) {
            int remainder = decimal % 26;
            column.insert(0, (char) ('A' + remainder));
            decimal = (decimal / 26) - 1;
        }
        return column.toString();
    }
}