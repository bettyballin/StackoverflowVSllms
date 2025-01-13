import org.junit.Test;
import static org.junit.Assert.assertTrue;
import java.io.IOException;

public class ExcelTest {
    @Test
    public void testExcelFile() throws IOException {
        ExcelComparator comparator = new ExcelComparator();
        String actualFilePath = "path/to/actual/file.xlsx";
        String expectedFilePath = "path/to/expected/file.xlsx";

        boolean areEqual = comparator.compareExcelFiles(actualFilePath, expectedFilePath);

        assertTrue(areEqual);
    }

    public static void main(String[] args) {
        org.junit.runner.JUnitCore.main("ExcelTest");
    }
}