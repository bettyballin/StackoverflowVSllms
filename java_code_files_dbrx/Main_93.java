public class Main {
    public static void main(String[] args) {
        char RECORD_SEPARATOR = '\u001E'; // Record Separator (RS)
        char END_OF_TEXT = '\u0003';      // End of Text (ETX)
        // Then concatenate or append these characters to your string using + operator, StringBuilder, or String.format(). For example:
        String test = "Test" + RECORD_SEPARATOR + "Message\u001E" + END_OF_TEXT;
        System.out.println(test); // Prints TestRSMessageETX
    }
}