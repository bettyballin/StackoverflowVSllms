import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

public class ChartImageServlet {
    public void doGet(HttpServletResponse response) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        // Assuming targetChart is an instance of a chart library class
        // Please replace with your actual chart library implementation
        // targetChart.createBufferedImage(600, 400).writeTo(baos, "PNG");
        byte[] chartBytes = baos.toByteArray();

        response.setContentType("image/png");
        ServletOutputStream out = response.getOutputStream();
        out.write(chartBytes);
        out.flush();
    }

    public static void main(String[] args) {
        // This main method is not used in a servlet context
        // It's here to make the code compile, but it doesn't do anything
    }
}