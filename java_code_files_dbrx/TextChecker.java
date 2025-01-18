import java.lang.String;
import java.util.List;
import java.util.ArrayList;
import org.jsoup.nodes.Element;

public class TextChecker {
    List<Element> paragraphs = new ArrayList<>();
    boolean isBold = paragraphs.get(0).hasAttr("style") && paragraphs.get(0).attr("style").contains("font-weight: bold");
    
    public static void main(String[] args) {
    }
}