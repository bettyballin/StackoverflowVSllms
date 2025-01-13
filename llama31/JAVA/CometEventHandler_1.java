import java.io.IOException;
import java.io.InputStream;
import java.io ServletException;
import java.lang.String;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CometEventHandler_1_1 {
    public void event(CometEvent event) throws IOException, ServletException {
        HttpServletRequest request = event.getHttpServletRequest();
        HttpServletResponse response = event.getHttpServletResponse();
        if (event.getEventType() == CometEvent.EventType.READ) {
            InputStream is = request.getInputStream();
            byte[] buf = new byte[512];
            do {
                int n = is.read(buf); // can throw an IOException
                if (n > 0) {
                    String message = new String(buf, 0, n);
                    messageSender.send("user", message);
                } else if (n < 0) {
                    // error(event, request, response);
                    System.out.println("you have an error");
                    return;
                }
            } while (is.available() > 0);
        }
    }

    public static void main(String[] args) {
    }
}