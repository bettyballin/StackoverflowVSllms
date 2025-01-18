public class Main {
    public static void main(String[] args) {
        float f = 123.456f; // Your floating point number here

        int numAsInt = Float.floatToRawIntBits(f); // Convert float to integer representation

        String hexStr = Integer.toHexString(numAsInt).toUpperCase(); // Convert int to hexadecimal string and make uppercase

        if (hexStr.startsWith("-")) {
            // Padding if negative number, else padding with 'zero' in front
            hexStr = "-" + String.format("%07X", numAsInt & 0x7FFFFFFF);
        } else {
            // Padding with zeros to make total length 8
            hexStr = String.format("%08X", numAsInt);
        }

        System.out.println(hexStr); // Print the resultant hexadecimal string with padded zeros
    }
}