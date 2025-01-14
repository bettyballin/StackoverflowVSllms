import java.lang.String;
public class HtmlLinkRemover {
    public static void main(String[] args) {
        String htmlString = "<p>I have a variable containing html string.  This string has this particular code</p><a href=\"http://www.pheedo.com/click.phdo?s=xxxxxxxx&amp;p=1\"><img border=\"0\" src=\"http://www.pheedo.com/img.phdo?s=xxxxxxxxxx&amp;p=1\" style=\"border: 0pt none ;\" alt=\"\"/></a><p>Thanks</p>";
        String cleanedHtml = htmlString.replaceAll("<a\\s+href=\"][^\"]*pheedo\\.com[^\"]*\">.*?<\\/a>", "");
        System.out.println(cleanedHtml);
    }
}