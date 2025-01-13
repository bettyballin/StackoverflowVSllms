import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.owasp.html.HtmlPolicyBuilder;
import org.owasp.html.PolicyFactory;

public class SaveCustomizationServlet extends HttpServlet {
  private static final PolicyFactory policy = new HtmlPolicyBuilder()
      .allowElements("p", "span", "a", "img")
      .allowAttributes("href", "src", "alt").globally()
      .toFactory();

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    String customHtml = req.getParameter("customHtml");
    String sanitizedHtml = policy.sanitize(customHtml);
    // Save sanitizedHtml to database or file
    // ...
  }

  public static void main(String[] args) {
  }
}