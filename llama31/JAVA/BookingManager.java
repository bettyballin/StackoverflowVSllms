import java.lang.String;
import javax.servlet.http.Cookie;

public class BookingManager {
    // Note: These variables and methods are not defined in the original code.
    // I assume they are defined elsewhere in the project.
    private User user;
    private Product product;
    private int quantity;
    private Database db;
    private javax.servlet.http.HttpServletResponse response;
    private javax.servlet.http.HttpServletRequest request;

    public void storeBooking() {
        // Store booking in database
        Booking booking = new Booking(user, product, quantity);
        db = new Database();
        db.storeBooking(booking);

        // Store session ID in encrypted cookie
        String sessionId = db.generateSessionId();
        Cookie cookie = new Cookie("session_id", sessionId);
        cookie.setSecure(true); // Ensure cookie is sent over HTTPS
        response.addCookie(cookie);
    }

    public void fetchBooking() {
        // Every page load, check cookie and fetch booking from database
        Cookie[] cookies = request.getCookies();
        String sessionId = null;
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("session_id")) {
                sessionId = cookie.getValue();
                break;
            }
        }
        if (sessionId != null) {
            Booking booking = db.getBookingBySessionId(sessionId);
            // Update booking information
        }
    }

    public static void main(String[] args) {
        // This method is empty, but it's required for the class to be executable.
    }
}

// These classes are not defined in the original code, so I assume they are defined elsewhere in the project.
class User {}
class Product {}
class Database {
    public void storeBooking(Booking booking) {}
    public String generateSessionId() { return ""; }
    public Booking getBookingBySessionId(String sessionId) { return new Booking(null, null, 0); }
}
class Booking {
    public Booking(User user, Product product, int quantity) {}
}