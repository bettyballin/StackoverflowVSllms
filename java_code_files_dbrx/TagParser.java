import java.lang.String;
import org.jsoup.*;
import org.jsoup.nodes.*;
import java.io.*;

public class TagParser {
    public static void main(String[] args) throws IOException{
        File input = new File("input.html"); //replace this with the path to your html file.
        Document doc = Jsoup.parse(input, "UTF-8", "");
        Element metaTag = doc.select("head > meta").first(); // replace 'meta' with the tag you're interested in: i.e., 'title', etc.
        if (metaTag != null) {
            System.out.println(metaTag.attr("content")); // replace 'content' attribute as required, for example: name, http-equiv, charset, etc.
        } else {
          System.err.print("Meta tag not found");
        }
    }
}