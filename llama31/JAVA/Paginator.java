import java.lang.Math;

public class Paginator {
    // Calculate total records and pages
    public static int getTotalRecordsFromDB() {
        // This method should be implemented to retrieve the total records from the database
        // For demonstration purposes, a dummy value is returned
        return 1000;
    }

    public static void main(String[] args) {
        Paginator paginator = new Paginator();
        paginator.paginate();
    }

    public void paginate() {
        int totalRecords = getTotalRecordsFromDB();
        int recordsPerPage = 100;
        int totalPages = (int) Math.ceil((double) totalRecords / recordsPerPage);

        // Fetch records for the current page
        int currentPage = 1; // example: current page
        int offset = (currentPage - 1) * recordsPerPage;
        String query = "SELECT * FROM table_name LIMIT " + recordsPerPage + " OFFSET " + offset;

        // Execute the query and display the records
        System.out.println("Total Records: " + totalRecords);
        System.out.println("Total Pages: " + totalPages);
        System.out.println("Query: " + query);
    }
}