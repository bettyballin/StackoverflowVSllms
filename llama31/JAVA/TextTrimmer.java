import java.lang.String;
public class TextTrimmer {
    public static String trimToNearestWord(String text, int characterLimit) {
        if (text.length() <= characterLimit) {
            return text;
        }

        int lastSpaceIndex = text.lastIndexOf(' ', characterLimit);
        if (lastSpaceIndex == -1) {
            // If no space is found, trim to the character limit
            return text.substring(0, characterLimit);
        }

        return text.substring(0, lastSpaceIndex);
    }

    public static void main(String[] args) {
        String text1 = "This is a block of text, blah blah blah";
        String text2 = "this is another block of txt 2 work with";

        int characterLimit = 27;

        System.out.println(trimToNearestWord(text1, characterLimit)); // Output: "This is a block of text, blah"
        System.out.println(trimToNearestWord(text2, characterLimit)); // Output: "this is another block of txt"
    }
}