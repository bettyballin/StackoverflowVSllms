import javax.servlet.http.HttpServletResponse;

public class CsvServlet {
    public void doGet(HttpServletResponse response) {
        response.setContentType("text/csv");
        response.setHeader("Content-Disposition", "attachment; filename=generated_file.csv");
    }
}