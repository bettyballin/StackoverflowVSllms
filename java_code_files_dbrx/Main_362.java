import java.time.*;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        // Define the input variables
        int year1 = 2023;
        int month1 = 10;
        int day1 = 1;
        int year2 = 2023;
        int month2 = 10;
        int day2 = 31;

        // Initial input (midnight-to-midnight)
        Date start = new Date(LocalDateTime.of(year1, month1, day1, 0, 0)
                .atZone(ZoneId.systemDefault()).toInstant().toEpochMilli());
        Date end = new Date(LocalDateTime.of(year2, month2, day2 + 1, 0, 0)
                .minusMinutes(1).atZone(ZoneId.systemDefault()).toInstant().toEpochMilli());

        // For demonstration, print the start and end dates
        System.out.println("Start date: " + start);
        System.out.println("End date: " + end);
    }
}