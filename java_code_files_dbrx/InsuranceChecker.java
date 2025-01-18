// Import required classes and packages
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.io.IOException;

public class InsuranceChecker {
    public static void main(String[] args) {
        String url = "https://example.com/insurance-check.jsp"; // Replace with target URL
        String insuranceNumber = "123ABCDEFG"; // Replace with your test insurance number

        try {
            Document document = Jsoup.connect(url)
                    .data("insurance_number", insuranceNumber) // Change input name accordingly to the actual website structure
                    .post();          // Use POST method for better security and sending form data directly

            System.out.println("Insurance check result: ");
            System.out.println(document);  // Print out all HTML content
        } catch (IOException e) {
            System.err.println("Error in connecting, parsing or scraping the page.");
            e.printStackTrace();
        }
    }
}