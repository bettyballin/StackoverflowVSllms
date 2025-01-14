import java.lang.String;
public class SafeCsvWriter {
    // Example of writing a value that looks like a date but should be treated as text
    String dateLikeText = "12/31";
    // Prepend an apostrophe to force Excel to treat it as text
    String safeDateLikeText = "'" + dateLikeText;

    // Writing the CSV line
    String csvLine = "OtherValue," + safeDateLikeText + ",AnotherValue";

    {
        System.out.println(csvLine);
    }

    public static void main(String[] args) {
        new SafeCsvWriter();
    }
}