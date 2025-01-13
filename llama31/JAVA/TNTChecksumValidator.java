import java.lang.String;
public class TNTChecksumValidator {
    public static boolean isValidTNTConsignmentNumber(String consignmentNumber) {
        int[] weights = {8, 6, 4, 2, 3, 5, 9, 7};
        int sum = 0;
        for (int i = 0; i < consignmentNumber.length(); i++) {
            int digit = Character.getNumericValue(consignmentNumber.charAt(i));
            sum += weights[i % weights.length] * digit;
        }
        return sum % 11 == 0;
    }

    public static void main(String[] args) {
        System.out.println(isValidTNTConsignmentNumber("12345678")); // Replace with a test consignment number
    }
}