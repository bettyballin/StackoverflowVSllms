import java.lang.String;
public class DateValidator_1 {

    public DateValidator_1(int year, int month) {
        if (year < 1 || year > 9999) {
            throw new IllegalArgumentException("Enter valid year");
        }
        // If we are using calendar months, month will always be between 1 and 12 inclusive
        if(month < 1 || month > 12){
            throw new IllegalArgumentException("Enter valid month: must be between 1 and 12.");
        }
    }

    public static void main(String[] args) {
    }
}