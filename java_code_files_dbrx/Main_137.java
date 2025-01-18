import java.lang.String;
import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.jsoup.nodes.Element;

public class Main_137 {
    public static void main(String[] args) throws Exception {
        Document doc = Jsoup.connect("http://www.csszengarden.com/stylesheets/205/style209.css").get(); // get css file from webpage
        Elements styleElements =  doc.select("style"); // select all elements with "style" tag or id etc..
         for(Element element : styleElements) {
            System.out.println(element);
          }
    }
}