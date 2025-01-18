import java.text.MessageFormat;

public class PercentFormatTest {
    public static void main(String[] args) {
        String expectedResult = "12.5%";
        double fraction = 0.125;

        // For proper formatting, use "#" for any digit and add extra pattern "#.##" to specify 2 decimal points.
        String actualResult = MessageFormat.format("{0,number,#.##%}", fraction);

        assert expectedResult.equals(actualResult) : actualResult + " should be formatted as " + expectedResult;
    }
}