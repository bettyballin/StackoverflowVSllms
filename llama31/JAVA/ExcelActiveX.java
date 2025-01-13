import java.lang.String;
import com.jacob.activeX.*;
import com.jacob.com.*;

public class ExcelActiveX {
    public static void main(String[] args) {
        Dispatch excel = new Dispatch("Excel.Application");
        Dispatch workbook = Dispatch.call(excel, "Workbooks").getDispatch();
        Dispatch sheet = Dispatch.call(workbook, "Sheets", "Sheet1").getDispatch();
        Dispatch cell = Dispatch.call(sheet, "Cells", 1, 1).getDispatch();
        System.out.println(Dispatch.get(cell, "Value"));
    }
}