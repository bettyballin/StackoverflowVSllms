import java.time.*;

public class Validator {
    public boolean isValidDate(int year, int month, int day) {
        try {
            LocalDate.of(year, month, day);
            return true;
        } catch (DateTimeException e){
            return false;
        }
    }
}