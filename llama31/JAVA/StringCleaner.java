import java.lang.String;

public class StringCleaner {
    public static void main(String[] args) {
        String originalString = "<p>&nbsp;<br /></p>Hello World<p><br />&nbsp;</p>";
        String cleanedString = originalString.replaceAll("<p>(\\s|&nbsp;|<br />)*</p>", "");
        System.out.println(cleanedString);
    }
}