import java.lang.String;
public class TextSteganography {
    public static String encodeMessage(String text, int secretNumber) {
        // Convert the number to a character and append it to the end of the text
        char hiddenChar = (char) secretNumber;
        return text + hiddenChar;
    }

    public static int decodeMessage(String encodedText) {
        // Get the last character of the string which represents the hidden number
        char hiddenChar = encodedText.charAt(encodedText.length() - 1);
        return (int) hiddenChar;
    }

    public static void main(String[] args) {
        String text = "The cat sat on the dog and was happy.";
        int secretNumber = 123;

        String encodedText = encodeMessage(text, secretNumber);
        System.out.println("Encoded Text: " + encodedText);

        int decodedNumber = decodeMessage(encodedText);
        System.out.println("Decoded Number: " + decodedNumber);
    }
}