import java.lang.String;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;
import java.io.IOException;
import org.apache.catalina.session.StandardSession;

public class CustomSessionIdSetter extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession httpSession = request.getSession(true); // creates new session or returns existing one depending on argument
        String customId = "yourCustomId";
        if (httpSession.isNew()) {
            ((StandardSession)httpSession).setId(customId);
        }
    }

    public static void main(String[] args) {
    }
}