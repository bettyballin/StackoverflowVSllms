import java.lang.String;
import java.text.MessageFormat;

public class PercentageFormatter {
    public static void main(String[] args) {
        String expectedResult = "12.5%";
        double fraction = 0.125;

        // Specify the number of decimal places after percent sign
        String pattern = "{0,number,percent,#.##}";
        String actualResult = MessageFormat.format(pattern, fraction);

        System.out.println(actualResult); // Output: 12.5%
        assert expectedResult.equals(actualResult) : actualResult + " should be formatted as " + expectedResult;
    }
}