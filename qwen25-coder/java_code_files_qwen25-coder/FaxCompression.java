import java.lang.String;
public class FaxCompression {
    public static void main(String[] args) {
        String input = "100111010001111100101010";
        System.out.println(compressFax(input));
    }

    public static String compressFax(String faxString) {
        if (faxString == null || faxString.isEmpty()) return "";

        StringBuilder compressed = new StringBuilder();
        int count = 1;
        char currentChar = faxString.charAt(0);

        for (int i = 1; i < faxString.length(); i++) {
            if (faxString.charAt(i) == currentChar) {
                count++;
            } else {
                compressed.append(count).append(":").append(currentChar).append(" ");
                currentChar = faxString.charAt(i);
                count = 1;
            }
        }

        // Append the last set of characters
        compressed.append(count).append(":").append(currentChar);

        return compressed.toString();
    }
}