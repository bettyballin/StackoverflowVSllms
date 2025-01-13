import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

public class BinaryServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        byte[] data = getBinaryFromSomeWhere();
        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment; filename=MyDocument.doc");
        OutputStream outputStream = response.getOutputStream();
        outputStream.write(data);
        outputStream.flush();
    }

    private byte[] getBinaryFromSomeWhere() {
        // Implement this method to retrieve the binary data
        return null;
    }
}