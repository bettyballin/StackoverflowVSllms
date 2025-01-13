import com.octoparse.Octoparse;
import com.octoparse.extractor.Extractor;
import com.octoparse.extractor.data.Data;

public class OctoparseExample {
    public static void main(String[] args) {
        // Create an Octoparse instance
        Octoparse octoparse = new Octoparse();

        // Create an extractor for the web page
        Extractor extractor = octoparse.createExtractor("https://www.example.com");

        // Add a data extraction task
        Data data = extractor.addData(new Data("Links", ".//a/@href"));

        // Run the extraction task
        extractor.run();

        // Print the extracted data
        System.out.println(data);
    }
}