import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        String html = ""; // Your desired HTML
        Document doc = Jsoup.parse(html); // or connect to URL, see https://jsoup.org/cookbook/input/load-document-from-url
        ArrayList<Element> matchedElements = new ArrayList<Element>(doc.getElementsByClass("classname")); // change 'classname' as needed
    }
}