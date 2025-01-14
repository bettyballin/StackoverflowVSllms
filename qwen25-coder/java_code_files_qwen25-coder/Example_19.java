import java.util.Date;

public class Example {
    public static void main(String[] args) {
        // Assuming 'timestampLong' is the long value received from the database
        long timestampLong = 1633072800000L; // Example timestamp
        Date date = new Date(timestampLong);

        // Create a dummy request object
        Request request = new Request();
        request.setAttribute("date", date);
    }
}

// Simple Request class with setAttribute method
class Request {
    public void setAttribute(String name, Object value) {
        // Implementation can be left empty or handle attributes as needed
        System.out.println("Attribute '" + name + "' set to: " + value);
    }
}