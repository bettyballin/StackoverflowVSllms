import java.lang.String;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.SingleThreadModel;

public class SingleThreadModelServlet extends HttpServlet implements SingleThreadModel {
    private final Object lock = new Object();

    @Override
    public void service(HttpServletRequest req, HttpServletResponse resp) {
        synchronized (lock) {
            // handle the request
        }
    }

	public static void main(String[] args) {
	}
}