import java.lang.String;
import com.sun.grizzly.comet.CometContext;
import com.sun.grizzly.comet.CometEngine;
import com.sun.grizzly.comet.CometEvent;
import com.sun.grizzly.http.servlet.GlassFishServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CometHandler extends GlassFishServlet {
  private CometContext context;

  public void init() throws ServletException {
    CometEngine engine = CometEngine.getEngine();
    context = engine.register("/comet-endpoint");
  }

  public void doGet(HttpServletRequest req, HttpServletResponse res) {
    context.addCometHandler(new CometHandler());
  }

  public void event(CometEvent event) {
    // Handle the event from the client
    if (event.getType() == CometEvent.Type.READ) {
      // Send a response back to the client
      try {
        event.getServletResponse().getWriter().write("Hello, client!");
      } catch (Exception e) {
        // Handle exception
      }
    }
  }

  public static void main(String[] args) {
  }
}