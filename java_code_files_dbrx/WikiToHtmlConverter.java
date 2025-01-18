import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class WikiToHtmlConverter {
    Pattern headingPattern = Pattern.compile("==(.+?)==");
    Pattern boldPattern = Pattern.compile("--(.+?)--");
    String html;

    public WikiToHtmlConverter(String wikiMarkup) {
        html = wikiMarkup;
        html = headingPattern.matcher(html).replaceAll("<h2>$1</h2>");
        html = boldPattern.matcher(html).replaceAll("<b>$1</b>");
    }

    public String getHtml() {
        return html;
    }

    public static void main(String[] args) {
        String wikiMarkup = "Some example ==heading== and --bold text-- in wiki markup.";
        WikiToHtmlConverter converter = new WikiToHtmlConverter(wikiMarkup);
        System.out.println(converter.getHtml());
    }
}