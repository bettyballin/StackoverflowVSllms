import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CreateExcelFile {
    public void createExcel() throws IOException {
        Workbook wb = new XSSFWorkbook();            //Create workbook object for xlsx file format
        Sheet sheet = wb.createSheet("Test");        //Create a worksheet named Test in our spreadsheet
        Row row;                                     // Declare row variable
        Cell cell;                                   // Declare cell variable
        String contents[] = {"Name", "Age", "Gender"};      //Contents of the cell to be written in single dimensional array.

        int i = 0;       //this integer value is just a counter to access each element of our string array variable 'contents' one by one.
        for (i = 0; i <= 2; i++) {             //Loop that will run through all elements of the array and write into cell each time when it runs.
            row = sheet.createRow(i);       //Create Row object within sheet object from previously defined/created spreadsheet by passing 'i' value as parameter to this method
            switch (getDataTypeFromContents(contents[i])) {                    //This is the condition written to decide what kind of data you want the cell to contain. In our case it checks the contents and if any number found, it makes these cells numeric type, otherwise a simple cell.
                default: {
                    cell = row.createCell(0);      //This is how you create cells within each row and also assigning numeric values starting from index zero.
                    // cell.setCellType(CellType.STRING);   //It defines that this particular cell will contain string value.
                    cell.setCellValue(contents[i]);             //Set value to the cells of each row and in respective columns as defined by their respective index numbers.
                }
            }
        }
        try {                         //try block is used to handle exceptions.
            FileOutputStream fileOut = new FileOutputStream("/home/user1/workbookexcel2k7.xlsx");  //Create an Excel workbook with specified name and extension .xlsx in particular directory of choice.(Make sure your path exists)
            wb.write(fileOut);                      //Write methods writes this Excel document file to the Disk with above created output stream argument as parameters
            fileOut.close();   // Close the file output stream
            System.out.println("created workbook.xlsx at /home/user1/workbookexcel2k7.xlsx");   //It will indicate whether your excel document has successfully written or not.
        } catch (Exception e) {
            System.out.println(e);       //Catch block will handle the possible exception which might cause problem while running application and prints on console as error message if anything goes wrong.
        }
    }

    // Placeholder method since getDataTypeFromContents is not defined
    private int getDataTypeFromContents(String content) {
        return 0;
    }

    public static void main(String[] args) throws IOException {
        CreateExcelFile obj = new CreateExcelFile();
        obj.createExcel();
    }
}