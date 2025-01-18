import java.time.*;
import java.time.temporal.*;
import java.util.*;
import java.text.MessageFormat;

public class FuzzyDateCalculator {

    private static final String[] timeText = {
        "a second ago",
        "a few seconds ago",
        "{0} minute ago",
        "{0} minutes ago",
        "{1} hour ago",
        "{1} hours ago"
    };

    private static final String[] todayText = {
        "just now",
        "earlier this morning",
        "{1} hour ago",
        "just afternoon",
        "early evening",
        "{1} hours ago in the evening",
        "yesterday early morning"
    };

    private static final String lastWeekDay[] = {
        "Monday",
        "Tuesday",
        "Wednesday",
        "Thursday",
        "Friday",
        "Saturday",
        "Sunday"
    };

    private static long timeDiff = 0, timeUnit = 0;

    public FuzzyDateCalculator() {
    }

    public String calculate(LocalDateTime dt1) {
        Instant instant = dt1.atZone(SystemDefaultZone()).toInstant();

        Duration duration = Duration.between(
            instant,
            LocalDateTime.now().atZone(SystemDefaultZone()).toInstant()
        );

        timeDiff = duration.getSeconds();

        if (timeDiff < 1) {
            return "just now";
        } else if (timeDiff <= 30) {
            return MessageFormat.format(
                timeText[new Random().nextInt(2) + 2],
                "a few"
            ); // a few seconds ago to avoid singular/plural confusion
        } else if (Math.abs(timeUnit = ChronoUnit.SECONDS.between(LocalDateTime.now(), dt1)) <= 60) {
            return MessageFormat.format(
                timeText[new Random().nextInt(2) + 2],
                timeUnit
            ); // a minute ago to...
        } else if (timeDiff >= 90 &&
                  Math.abs(ChronoUnit.MINUTES.between(LocalDateTime.now(), dt1)) <= 61) {
            return "a few minutes ago"; // few minutes
        } else if (Math.abs(timeUnit = ChronoUnit.MINUTES.between(LocalDateTime.now().truncatedTo(ChronoUnit.DAYS), dt1)) <= 60) {
            if (dt1.getHour() < 12) {
                return MessageFormat.format(
                    todayText[new Random().nextInt(3) + 2],
                    Math.abs(timeUnit)
                ); // just morning, earlier this morning, 1 hour ago in the morning
            } else if (dt1.getHour() >= 16 &&
                       dt1.getDayOfMonth() == LocalDateTime.now().truncatedTo(ChronoUnit.DAYS).getDayOfMonth()) {
                return MessageFormat.format(
                    todayText[new Random().nextInt(2) + 2],
                    Math.abs(timeUnit)
                ); // early evening, 1 hour ago in the evening
            } else {
                return "yesterday early morning";
            }
        } else {
            // last day cases
            if (Math.abs(ChronoUnit.DAYS.between(LocalDateTime.now().truncatedTo(ChronoUnit.WEEKS), dt1)) == 2) {
                return lastWeekDay[new Random().nextInt(7)]; // random days from the past week
            } else if (Math.abs(timeUnit = ChronoUnit.DAYS.between(LocalDateTime.now(), dt1)) <= 30) {
                return MessageFormat.format("{0} days ago", timeUnit); // less than a month
            } else {
                return "more than a month"; // greater than a month
            }
        }
    }

    public static ZoneId SystemDefaultZone() {
        return Clock.systemDefaultZone().getZone();
    }
}