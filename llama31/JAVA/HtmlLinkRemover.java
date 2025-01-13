import java.lang.String;

public class HtmlLinkRemover {
    public static void main(String[] args) {
        String text = "<blockquote>\n" +
                "  <p><strong>Possible Duplicate:</strong><br>\n" +
                "  <a href=\"https://stackoverflow.com/questions/1732348/regex-match-open-tags-except-xhtml-self-contained-tags\">RegEx match open tags except XHTML self-contained tags</a>  </p>\n" +
                "</blockquote>\n" +
                "\n" +
                "\n" +
                "<p>I have a HTML page with</p>\n" +
                "\n" +
                "<pre><code><a class=\"development\" href=\"[variable content]\">X</a>\n" +
                "</code></pre>\n" +
                "\n" +
                "<p>The [variable content] is different in each place, the rest is the same.<br>\n" +
                "What regexp will catch all of those links?\n" +
                "(Although I am not writing it here, I did try...) </p>\n";

        String cleanText = text.replaceAll("<a.*?>.*?<\\/a>", "");
        System.out.println(cleanText);
    }
}