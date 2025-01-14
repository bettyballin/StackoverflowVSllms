import java.lang.String;
public class ExcelColumnName {
    public static String getExcelColumnName(int columnNumber) {
        StringBuilder columnName = new StringBuilder();
        
        while (columnNumber >= 0) {
            int remainder = (columnNumber % 26);
            char currentLetter = (char) ('A' + remainder);
            columnName.insert(0, currentLetter);
            columnNumber = (columnNumber / 26) - 1;
        }
        
        return columnName.toString();
    }

    public static void main(String[] args) {
        System.out.println(getExcelColumnName(0));   // Output: A
        System.out.println(getExcelColumnName(25));  // Output: Z
        System.out.println(getExcelColumnName(26));  // Output: AA
        System.out.println(getExcelColumnName(700)); // Output: AVI
    }
}