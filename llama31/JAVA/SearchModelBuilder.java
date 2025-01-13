import java.util.Map;
import java.util.HashMap;

public class SearchModelBuilder {
    Map<String, Object> model = new HashMap<>();
    String keywords = "some keywords"; // Define the keywords variable

    public SearchModelBuilder() {
        model.put("keywords", keywords);
    }

    public static void main(String[] args) {
        SearchModelBuilder modelBuilder = new SearchModelBuilder();
    }
}