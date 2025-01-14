import java.lang.String;
import org.jsoup.nodes.*;

public class BoldTextPrinter {
    Document document = null;

    {
        Elements boldText = document.select("b, strong");
        for (Element elem : boldText) {
            System.out.println(elem.text());
        }
    }

    public static void main(String[] args) {
    }
}