import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class attribute {
    public static void main(String[] args) {
        // assuming you have imported the package correctly and `htmlCode` contains the HTML code as a string
        String html = "<tagname class='classname'>Some content</tagname>"; // replace with actual value of your HTML body
        Document doc = Jsoup.parse(html); // creates a Jsoup document out of the supplied markup
        Elements elementsWithGivenClassName = doc.select(".classname"); // gets all element instances that have `classname` within their class attribute, regardless of what other classes they may also belong to
        Elements elementsWithExactClassAttributeValue = doc.select("tagname[class='classname']"); // will get any <tagname> elements whose only class is 'classname' - order does not matter
    }
}