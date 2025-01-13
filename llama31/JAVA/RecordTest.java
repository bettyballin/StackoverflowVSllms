import java.util.ArrayList;
import java.util.List;

// Define the Record class
class Record {
    private int id;
    private String name;
    private String surname;

    public Record(int id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }
}

// Define the Filter class
class Filter {
    private String field;
    private String value;

    public Filter(String field, String value) {
        this.field = field;
        this.value = value;
    }

    public List<Record> apply(List<Record> records) {
        List<Record> filteredRecords = new ArrayList<>();
        for (Record record : records) {
            if (record.getName().equals(value)) {
                filteredRecords.add(record);
            }
        }
        return filteredRecords;
    }
}

// Define the SortOrder class
class SortOrder {
    public enum Direction { ASC, DESC }
    private String field;
    private Direction direction;

    public SortOrder(String field, Direction direction) {
        this.field = field;
        this.direction = direction;
    }

    public List<Record> apply(List<Record> records) {
        records.sort((r1, r2) -> {
            if (direction == Direction.ASC) {
                return r1.getName().compareTo(r2.getName());
            } else {
                return r2.getName().compareTo(r1.getName());
            }
        });
        return records;
    }
}

public class RecordTest {

    // Mock data source
    static List<Record> records = new ArrayList<>();
    static {
        records.add(new Record(1, "John", "Doe"));
        records.add(new Record(2, "Jane", "Doe"));
        records.add(new Record(3, "Bob", "Smith"));
    }

    // Test filtering
    public static void testFiltering() {
        // Set up the filter
        Filter filter = new Filter("name", "John");

        // Apply the filter to the data source
        List<Record> filteredRecords = filter.apply(records);

        // Verify the results
        System.out.println("Test Filtering:");
        System.out.println("Expected size: 1, Actual size: " + filteredRecords.size());
        System.out.println("Expected name: John, Actual name: " + filteredRecords.get(0).getName());
    }

    // Test sorting
    public static void testSorting() {
        // Set up the sort order
        SortOrder sortOrder = new SortOrder("name", SortOrder.Direction.ASC);

        // Sort the records
        List<Record> sortedRecords = new ArrayList<>(records); // Create a copy
        sortedRecords = sortOrder.apply(sortedRecords);

        // Verify the results
        System.out.println("\nTest Sorting:");
        System.out.println("Expected size: 3, Actual size: " + sortedRecords.size());
        System.out.println("Expected name: Bob, Actual name: " + sortedRecords.get(0).getName());
        System.out.println("Expected name: Jane, Actual name: " + sortedRecords.get(1).getName());
        System.out.println("Expected name: John, Actual name: " + sortedRecords.get(2).getName());
    }

    // Test paging
    public static void testPaging() {
        // Set up the page size and page number
        int pageSize = 2;
        int pageNumber = 0; // Changed to 0 to get the first page

        // Get the records for the page
        List<Record> pageRecords = records.subList(pageNumber * pageSize, (pageNumber + 1) * pageSize);

        // Verify the results
        System.out.println("\nTest Paging:");
        System.out.println("Expected size: 2, Actual size: " + pageRecords.size());
        System.out.println("Expected name: John, Actual name: " + pageRecords.get(0).getName());
        System.out.println("Expected name: Jane, Actual name: " + pageRecords.get(1).getName());
    }

    public static void main(String[] args) {
        testFiltering();
        testSorting();
        testPaging();
    }
}