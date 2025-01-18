import java.lang.String;
import java.lang.ArrayList;
import java.lang.Integer;
import java.time.*;
import java.util.*;

public class ScheduleManager {

    private String[][] schedule = {
        {"M", "tTS", "Any",  "tTS"}, // Group A
        {"t",  "TMW", "AnyTFS", "MF" },// Group B and so on...
       };

    public ArrayList<DayOfWeek> getAllowedDays(char group, LocalDate date){
      Season season = this.getSeason(date);
      int index = group - 'A'; // Convert char to integer offset for array
      String[] days = schedule[index];
      return this.parseAllowedDays(days[(season.ordinal())]);
    }

    private ArrayList<DayOfWeek> parseAllowedDays(String input){
        ArrayList<DayOfWeek> results = new ArrayList<>();
        for (int i=0;i<input.length();++i) { // Loop through each character in the string
            char c = input.charAt(i);   // Get a single character
            if (c != 'A' && c!= 'n'  && c != 'y'){ // Ignore Any as special case for simplicity
                 results.add(charToDayOfWeek(c));// Use mapping to get the day from its abbreviation
            }
        }
        if (input.contains("Any")) {    // If days contains 'Any' return all days of week
          for (DayOfWeek day : DayOfWeek.values()) {   // Loop and add each day enum to collection
             results.add(day);       // Add all seven days of week since any day works for Any
            }
        }
         return results;            // Return the ArrayList with parsed day (or days)
    }

    private DayOfWeek charToDayOfWeek(char c) {
        switch(c) {
            case 'M': return DayOfWeek.MONDAY;
            case 't': return DayOfWeek.TUESDAY;
            case 'W': return DayOfWeek.WEDNESDAY;
            case 'T': return DayOfWeek.THURSDAY;
            case 'F': return DayOfWeek.FRIDAY;
            case 'S': return DayOfWeek.SATURDAY;
            case 's': return DayOfWeek.SUNDAY;
            default: throw new IllegalArgumentException("Invalid day character: " + c);
        }
    }

    private Season getSeason(LocalDate date){  // Given a LocalDate, determine season
      int monthValue = date.getMonthValue();    // Get current month
      int dayOfMonth = date.getDayOfMonth();     // Get current day of the month for precise matching
        for (Season s : Season.values()) {
            int startMonth = Integer.parseInt(s.start.split("-")[0]);
            int startDay = Integer.parseInt(s.start.split("-")[1]);
            int endMonth = Integer.parseInt(s.end.split("-")[0]);
            int endDay = Integer.parseInt(s.end.split("-")[1]);

            boolean afterStart = (monthValue > startMonth) || (monthValue == startMonth && dayOfMonth >= startDay);
            boolean beforeEnd = (monthValue < endMonth) || (monthValue == endMonth && dayOfMonth <= endDay);

            if (s == Season.WINTER) {
                // Handle seasons that span the year-end
                if (afterStart || beforeEnd) {
                    return s;
                }
            } else {
                if (afterStart && beforeEnd) {
                    return s;
                }
            }
        }
       throw new RuntimeException("Could not determine season.");   // Should never happen but best be proactive and plan for the worst. If we reach here, something is wrong with data or code logic.
    }

    enum Season {
        WINTER("12-21", "3-19"),
        SPRING("3-20", "6-20"),
        SUMMER("6-21", "9-21"),
        FALL("9-22", "12-20");

        public final String start;
        public final String end;

        Season(String start, String end){
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) {
    }
}