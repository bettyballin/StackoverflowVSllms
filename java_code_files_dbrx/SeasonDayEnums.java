import java.lang.String;
public class SeasonDayEnums {
public enum Season {
    WINTER("11-01", "02-28"),   // Format is MM-DD
    SPRING("03-01", "04-30"),
    SUMMER("05-01", "08-31"),
    FALL("09-01", "10-31");

    public final String start;
    public final String end;

    Season(String start, String end) {
        this.start = start;
        this.end = end;
    }
}

public enum DayOfWeek {
    MONDAY("M"), TUESDAY("Tu"), WEDNESDAY("W"), THURSDAY("Th"), FRIDAY("F"), SATURDAY("Sa"), SUNDAY("Su");

    public final String abbreviation;

    DayOfWeek(String abbreviation) {
        this.abbreviation = abbreviation;
    }
}
    public static void main(String[] args) {
    }
}