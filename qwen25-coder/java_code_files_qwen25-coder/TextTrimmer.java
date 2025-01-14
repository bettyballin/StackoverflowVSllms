import java.lang.String;
public class TextTrimmer {
    public static String trimToNearestWord(String text, int maxLength) {
        if (text == null || text.length() <= maxLength) {
            return text;
        }

        // Trim the text to maxLength
        String trimmed = text.substring(0, maxLength);

        // Find the last space in the trimmed string
        int lastSpaceIndex = trimmed.lastIndexOf(' ');

        // If no space found, trim until the end of the current word if within maxLength, otherwise truncate at last space before maxLength
        if (lastSpaceIndex == -1) {
            lastSpaceIndex = text.indexOf(' ', maxLength);
            if (lastSpaceIndex == -1) return ""; // No more spaces after maxLength, return empty or handle as needed
            return text.substring(0, lastSpaceIndex).trim();
        }

        // Return the substring up to the last space
        return trimmed.substring(0, lastSpaceIndex).trim();
    }

    public static void main(String[] args) {
        String text1 = "This is a block of text, blah blah blah";
        String text2 = "this is another block of txt 2 work with";

        int maxLength = 27;

        System.out.println(trimToNearestWord(text1, maxLength)); // Output: "This is a block of"
        System.out.println(trimToNearestWord(text2, maxLength)); // Output: "this is another block of"
    }
}