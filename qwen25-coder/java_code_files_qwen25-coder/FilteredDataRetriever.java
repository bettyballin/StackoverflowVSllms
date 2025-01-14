import java.util.List;
import java.util.ArrayList;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class FilteredDataRetriever {
    // Assuming 'yourData' is the list of strings fetched from your database column.
    List<String> filteredData = new ArrayList<>();
    String regexPattern = "your_regex_pattern";
    Pattern pattern = Pattern.compile(regexPattern);

    public FilteredDataRetriever(List<String> yourData) {
        for (String data : yourData) {
            Matcher matcher = pattern.matcher(data);
            if (matcher.matches()) {
                filteredData.add(data);
            }
        }
    }

    public static void main(String[] args) {
        // Example usage
        List<String> yourData = new ArrayList<>();
        // Add data to yourData as needed
        yourData.add("example1");
        yourData.add("example2");
        // Initialize the FilteredDataRetriever with your data
        FilteredDataRetriever retriever = new FilteredDataRetriever(yourData);
        // Access the filtered data
        for(String data : retriever.filteredData) {
            System.out.println(data);
        }
    }
}