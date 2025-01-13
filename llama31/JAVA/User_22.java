import java.util.Date;
import java.util.List;

// Assuming @Entity, @Id, and @Repeated are not necessary for the compilation and execution demonstration.
// These annotations are typically used with JPA (Java Persistence API).

public class User_22_22 {
    private Long userId;
    private String fname;
    private String lname;
    private List<Ticket> tickets;

    public static class Ticket {
        private Long ticketId;
        private String flightNo;
        private Flight flightDetails;
    }

    public static class Flight {
        private String airline;
        private Date departureTime;
        private Date arrivalTime;
    }

    public static void main(String[] args) {
        // You can add your implementation here.
    }
}