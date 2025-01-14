import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import static org.apache.poi.ss.usermodel.CellType.*;

public class ExcelComparator {

    public static boolean areExcelFilesEqual(String file1Path, String file2Path) {
        try (FileInputStream fis1 = new FileInputStream(file1Path);
             FileInputStream fis2 = new FileInputStream(file2Path);
             Workbook workbook1 = new XSSFWorkbook(fis1);
             Workbook workbook2 = new XSSFWorkbook(fis2)) {

            return areWorkbooksEqual(workbook1, workbook2);

        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    private static boolean areWorkbooksEqual(Workbook wb1, Workbook wb2) {
        if (wb1.getNumberOfSheets() != wb2.getNumberOfSheets()) {
            return false;
        }
        for (int i = 0; i < wb1.getNumberOfSheets(); i++) {
            Sheet sheet1 = wb1.getSheetAt(i);
            Sheet sheet2 = wb2.getSheetAt(i);

            if (!areSheetsEqual(sheet1, sheet2)) {
                return false;
            }
        }
        return true;
    }

    private static boolean areSheetsEqual(Sheet sheet1, Sheet sheet2) {
        Iterator<Row> rowIterator1 = sheet1.iterator();
        Iterator<Row> rowIterator2 = sheet2.iterator();

        while (rowIterator1.hasNext() && rowIterator2.hasNext()) {
            Row row1 = rowIterator1.next();
            Row row2 = rowIterator2.next();

            if (!areRowsEqual(row1, row2)) {
                return false;
            }
        }

        // If one of the sheets has more rows than the other
        if (rowIterator1.hasNext() || rowIterator2.hasNext()) {
            return false;
        }

        return true;
    }

    private static boolean areRowsEqual(Row row1, Row row2) {
        Iterator<Cell> cellIterator1 = row1.cellIterator();
        Iterator<Cell> cellIterator2 = row2.cellIterator();

        while (cellIterator1.hasNext() && cellIterator2.hasNext()) {
            Cell cell1 = cellIterator1.next();
            Cell cell2 = cellIterator2.next();

            if (!areCellsEqual(cell1, cell2)) {
                return false;
            }
        }

        // If one of the rows has more cells than the other
        if (cellIterator1.hasNext() || cellIterator2.hasNext()) {
            return false;
        }

        return true;
    }

    private static boolean areCellsEqual(Cell cell1, Cell cell2) {
        switch (cell1.getCellType()) {
            case STRING:
                return cell1.getStringCellValue().equals(cell2.getStringCellValue());
            case NUMERIC:
                if (DateUtil.isCellDateFormatted(cell1)) {
                    return cell1.getDateCellValue().equals(cell2.getDateCellValue());
                } else {
                    return cell1.getNumericCellValue() == cell2.getNumericCellValue();
                }
            // You should handle other types like BOOLEAN, FORMULA, etc. as needed
            case BOOLEAN:
                return cell1.getBooleanCellValue() == cell2.getBooleanCellValue();
            default:
                return true; // Consider cells of unsupported types as equal if they reach this point
        }
    }

    public static void main(String[] args) {
        String file1Path = "path/to/your/actual.xlsx";
        String file2Path = "path/to/your/expected.xlsx";

        boolean areEqual = areExcelFilesEqual(file1Path, file2Path);
        System.out.println("Are the Excel files equal? " + areEqual);
    }
}