import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ValidateArticleRequestHandler extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String articleId = request.getParameter("article_id");
        if (articleId != null && !articleId.matches("^[0-9]+$")) {
            response.sendRedirect("index.jsp");
            return; // Ensure no further code is executed after the redirect
        }
        // Proceed with rest of your logic or forwarding to another page/resource
    }

    public static void main(String[] args) {
    }
}