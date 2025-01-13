import java.lang.String;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;

import javax.servlet.annotation.WebServlet;

@WebServlet("/article")
public class ArticleServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String articleId = request.getParameter("article_id");
        if (!articleId.matches("^[0-9]+$")) {
            response.sendRedirect("index.jsp");
            return;
        }
        // Rest of the servlet logic
    }

    public static void main(String[] args) {
    }
}