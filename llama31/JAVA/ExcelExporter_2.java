import java.io.IOException;
import java.io.OutputStream;
import java.lang.String;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ExcelExporter_2_2 {
    public void exportExcel(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // assuming 'transformer' and 'beans' are defined elsewhere
        HSSFWorkbook hm = transformer.transformXLS(is, beans);
        resp.setContentType("application/vnd.ms-excel");
        String filename = "example.xls";

        ServletOutputStream out = resp.getOutputStream();
        hm.write(out);
        out.flush();
        out.close();
    }

    public static void main(String[] args) {
        // main method remains empty
    }
}