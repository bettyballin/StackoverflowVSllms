public class RemoveHTMLTags {
    public static void main(String[] args) {
        String input = "<SYNC Start=364><P Class=KRCC>\n<Font Color=lightpink>abcd\n";
        // Regular expression to match the specific pattern
        String regex = "<P Class=KRCC><Font Color=lightpink>";
        // Replace matched pattern with an empty string
        String result = input.replaceFirst(regex, "");
        System.out.println(result);
    }
}