import javax.servlet.http.HttpServlet;
import javax.servlet.annotation.SessionTrackingMode;
import javax.servlet.SessionTrackingMode.TrackingMode;

@SessionTrackingMode(TrackingMode.COOKIE)
public class MyServlet_3_3 extends HttpServlet {
    // ...

    public static void main(String[] args) {
    }
}