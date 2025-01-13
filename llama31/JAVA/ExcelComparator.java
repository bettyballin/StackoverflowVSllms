import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelComparator {

    public boolean compareExcelFiles(String filePath1, String filePath2) throws IOException {
        try (Workbook workbook1 = new XSSFWorkbook(new FileInputStream(filePath1));
             Workbook workbook2 = new XSSFWorkbook(new FileInputStream(filePath2))) {

            if (workbook1.getNumberOfSheets() != workbook2.getNumberOfSheets()) {
                return false;
            }

            for (int i = 0; i < workbook1.getNumberOfSheets(); i++) {
                Sheet sheet1 = workbook1.getSheetAt(i);
                Sheet sheet2 = workbook2.getSheetAt(i);

                if (!compareSheets(sheet1, sheet2)) {
                    return false;
                }
            }

            return true;
        }
    }

    private boolean compareSheets(Sheet sheet1, Sheet sheet2) {
        if (sheet1.getLastRowNum() != sheet2.getLastRowNum()) {
            return false;
        }

        for (int i = 0; i <= sheet1.getLastRowNum(); i++) {
            Row row1 = sheet1.getRow(i);
            Row row2 = sheet2.getRow(i);

            if (!compareRows(row1, row2)) {
                return false;
            }
        }

        return true;
    }

    private boolean compareRows(Row row1, Row row2) {
        if (row1.getLastCellNum() != row2.getLastCellNum()) {
            return false;
        }

        for (int i = 0; i < row1.getLastCellNum(); i++) {
            Cell cell1 = row1.getCell(i);
            Cell cell2 = row2.getCell(i);

            if (!compareCells(cell1, cell2)) {
                return false;
            }
        }

        return true;
    }

    private boolean compareCells(Cell cell1, Cell cell2) {
        if (cell1 == null && cell2 == null) {
            return true;
        }

        if (cell1 == null || cell2 == null) {
            return false;
        }

        switch (cell1.getCellType()) {
            case STRING:
                return cell1.getStringCellValue().equals(cell2.getStringCellValue());
            case NUMERIC:
                return cell1.getNumericCellValue() == cell2.getNumericCellValue();
            case BOOLEAN:
                return cell1.getBooleanCellValue() == cell2.getBooleanCellValue();
            default:
                return false;
        }
    }

    public static void main(String[] args) throws IOException {
        ExcelComparator comparator = new ExcelComparator();
        System.out.println(comparator.compareExcelFiles("file1.xlsx", "file2.xlsx"));
    }
}