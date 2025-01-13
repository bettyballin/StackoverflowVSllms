/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.http.Cookie
 *  javax.servlet.http.HttpServletRequest
 *  javax.servlet.http.HttpServletResponse
 */
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BookingManager {
    private User user;
    private Product product;
    private int quantity;
    private Database db;
    private HttpServletResponse response;
    private HttpServletRequest request;

    public void storeBooking() {
        Booking booking = new Booking(this.user, this.product, this.quantity);
        this.db = new Database();
        this.db.storeBooking(booking);
        String string = this.db.generateSessionId();
        Cookie cookie = new Cookie("session_id", string);
        cookie.setSecure(true);
        this.response.addCookie(cookie);
    }

    public void fetchBooking() {
        Cookie[] cookieArray = this.request.getCookies();
        String string = null;
        for (Cookie cookie : cookieArray) {
            if (!cookie.getName().equals("session_id")) continue;
            string = cookie.getValue();
            break;
        }
        if (string != null) {
            Booking booking = this.db.getBookingBySessionId(string);
        }
    }

    public static void main(String[] stringArray) {
    }
}
