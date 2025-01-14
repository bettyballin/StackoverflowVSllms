import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class Main_27 {
    public static void main(String[] args) throws Exception {
        String htmlContent = "... your HTML content here ...";
        Document doc = Jsoup.parse(htmlContent);

        // Using CSS selectors to find elements
        String productDimensions = doc.selectFirst("a#productDetails + table h2:contains(Product Details) ~ div li b:contains(Product Dimensions:)")
            .nextSibling()
            .toString()
            .trim();

        System.out.println(productDimensions);
    }
}