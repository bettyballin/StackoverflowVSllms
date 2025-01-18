import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import java.io.*;

public class ExcelCompare {
    public static void main(String[] args) throws IOException, InvalidFormatException {
        InputStream input1 = new FileInputStream("path/to/your-first-excel-file.xlsx"); // your first excel file as inputstream
        Workbook wb1 = WorkbookFactory.create(input1);
        Sheet sheet1 = findSheetByContent("your-sheet-name", wb1); // get the sheet from workbook which you want to compare with.

        InputStream input2 = new FileInputStream("path/to/your-second-excel-file.xlsx"); // your second excel file as inputstream
        Workbook wb2 = WorkbookFactory.create(input2);
        Sheet sheet2 = findSheetByContent("your-sheet-name", wb2); // get the sheet from workbook which you want to compare with.

        compareRowAndCellValues(sheet1, sheet2);
    }

    public static void compareRowAndCellValues(Sheet sheet1, Sheet sheet2) {
        for (int i = 0; i <= Math.min(sheet1.getLastRowNum(), sheet2.getLastRowNum()); i++) { // traverse all rows in both sheets
            Row row1 = sheet1.getRow(i);
            Row row2 = sheet2.getRow(i);
            if (row1 == null || row2 == null)
                throw new RuntimeException("Rows differ at index " + i + ". One is null."); // rows are not equal as one is null

            for (int j = 0; j < Math.min(row1.getLastCellNum(), row2.getLastCellNum()); j++) {  // traverse all cells in both rows
                Cell cell1 = row1.getCell(j, Row.MissingCellPolicy.RETURN_NULL_AND_BLANK);
                Cell cell2 = row2.getCell(j, Row.MissingCellPolicy.RETURN_NULL_AND_BLANK);
                if (cell1 == null || cell2 == null)
                    throw new RuntimeException("Cells differ at index " + j + ". One is null."); // cells are not equal as one is null

                // compare content of individual cells. For other data types, you'll have to add appropriate comparison based on your requirement.
                if (!cell1.getStringCellValue().equals(cell2.getStringCellValue()))
                    throw new RuntimeException("Cells differ in values: Cell1 value - " + cell1.getStringCellValue() + ", Cell2 value - " + cell2.getStringCellValue()); // Cells do not contain same value.
            }
        }
    }

    private static Sheet findSheetByContent(String sheetName, Workbook wb) {
        Sheet sheet = wb.getSheet(sheetName);
        if (sheet != null) {
            return sheet; // found the sheet with the given name
        }
        // Implement logic to search based on content if needed
        return null;
    }
}