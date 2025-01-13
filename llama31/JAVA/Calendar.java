// This is not Java code, it appears to be a JSP (Java Server Pages) tag.
// However, I can provide you with a simple Java class that can be compiled with javac.

// Example Java class
public class Calendar {
    private String id;
    private String dataSource;

    public Calendar(String id, String dataSource) {
        this.id = id;
        this.dataSource = dataSource;
    }

    public String getId() {
        return id;
    }

    public String getDataSource() {
        return dataSource;
    }

    public static void main(String[] args) {
        Calendar calendar = new Calendar("calendar", "/my/events");
        System.out.println("Id: " + calendar.getId());
        System.out.println("Data Source: " + calendar.getDataSource());
    }
}