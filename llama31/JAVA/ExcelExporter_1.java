import java.io.IOException;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ExcelExporter_1_1 {
    public void exportExcel(HttpServletResponse resp) throws IOException {
        HSSFWorkbook hm = (HSSFWorkbook) resp.getSession().getAttribute("excelWorkBook");
        resp.setContentType("application/vnd.ms-excel");
        String filename = "example.xls";

        resp.setHeader("Content-Disposition", "attachment; filename=\"" + filename + "\"");

        resp.getOutputStream().write(hm.getBytes());
        resp.getOutputStream().flush();
        resp.getOutputStream().close();
    }

    public static void main(String[] args) {
    }
}