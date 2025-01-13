import java.text.MessageFormat;

public class NumberFormatterTest {
    public static void main(String[] args) {
        String expectedResult = "12.5%";
        double fraction = 0.125;

        String actualResult = MessageFormat.format("{0,number,#,##0.0##%}", fraction);
        assert expectedResult.equals(actualResult) : actualResult +" should be formatted as "+expectedResult;
    }
}