public class BinaryAdder {
    // Example snippet showing binary addition (simplistic view of ALU operation)
    public static String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();  // Stores final result.
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;

        while (i >= 0 || j >= 0) {
            int sum = carry;   // Add carry from last addition

            if (i >= 0) sum += a.charAt(i--) - '0';  // Convert char to binary digit.

            if (j >= 0) sum += b.charAt(j--) - '0';  // Similarly for other number.

            sb.append((char)(sum % 2 + '0'));  // Add the current bit into StringBuilder.

            carry = sum / 2;   // Determine if there will be any carry value.
        }

        if (carry != 0) sb.append('1');      // If there is still carry, add it to the result.

        return sb.reverse().toString();         // Reverse the string since bits were added in reverse order.
    }

    public static void main(String[] args) {
    }
}