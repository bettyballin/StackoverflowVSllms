import net.sf.jxls.transformer.XLSTransformer;
import org.apache.poi.ss.usermodel.Workbook;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Map;
import java.util.HashMap;

@WebServlet("/generate-excel")
public class ExcelServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Assuming you have the template and beans setup already
        String templateFileName = "path/to/template.xls";
        Map<String, Object> beans = new HashMap<>(); // your beans here

        XLSTransformer transformer = new XLSTransformer();
        try (InputStream is = new BufferedInputStream(new FileInputStream(templateFileName));
             Workbook workbook = transformer.transformXLS(is, beans);
             ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream()) {
            
            workbook.write(byteArrayOutputStream);

            // Set headers and write output to response
            resp.setContentType("application/vnd.ms-excel");
            resp.setHeader("Content-Disposition", "inline; filename=output.xls");

            byte[] bytes = byteArrayOutputStream.toByteArray();
            resp.setContentLength(bytes.length);
            try (OutputStream out = resp.getOutputStream()) {
                out.write(bytes);
            }
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}