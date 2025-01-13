import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main_184 {
    public static void main(String[] args) {
        // assume 'inputDate' is your input string in the format "Aug-6-2009"
        String inputDate = "Aug-6-2009";

        // define the input and output date formats
        SimpleDateFormat inputFormat = new SimpleDateFormat("MMM-d-yyyy");
        SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd");

        // parse the input date string into a Date object
        Date date;
        try {
            date = inputFormat.parse(inputDate);
        } catch (ParseException e) {
            // handle parsing error
            System.out.println("Error parsing date: " + e.getMessage());
            return;
        }

        // format the Date object into the desired output format
        String mysqlDate = outputFormat.format(date);

        // 'mysqlDate' now holds the formatted date string "2009-08-06"
        System.out.println(mysqlDate);
    }
}