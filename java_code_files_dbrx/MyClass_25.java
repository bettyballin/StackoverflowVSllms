import java.time.*;
import java.time.format.DateTimeFormatter;

public class MyClass {
    public static void main(String[] args) {
        String input = "+2 days"; // This could be any valid String input, including those with a custom timezone offset.
        Instant instantNow = Instant.now();

        // Parse the input to create a Duration
        Duration duration = parseDurationFromInput(input);

        // Now add this duration to our predefined instant, i.e., 'now'
        instantNow = instantNow.plus(duration);

        System.out.println(instantNow.atZone(ZoneId.systemDefault()).format(DateTimeFormatter.ISO_INSTANT));
    }

    private static Duration parseDurationFromInput(String input) {
        // Implement parsing logic here
        // For example, convert "+2 days" to Duration.ofDays(2)
        input = input.trim();
        long amount = 0;
        if (input.startsWith("+") || input.startsWith("-")) {
            char sign = input.charAt(0);
            input = input.substring(1).trim();
            String[] parts = input.split(" ");
            amount = Long.parseLong(parts[0]);
            if (sign == '-') {
                amount = -amount;
            }
            String unit = parts[1].toLowerCase();
            switch (unit) {
                case "day":
                case "days":
                    return Duration.ofDays(amount);
                case "hour":
                case "hours":
                    return Duration.ofHours(amount);
                case "minute":
                case "minutes":
                    return Duration.ofMinutes(amount);
                case "second":
                case "seconds":
                    return Duration.ofSeconds(amount);
                default:
                    throw new IllegalArgumentException("Unknown time unit: " + unit);
            }
        } else {
            // Handle inputs without + or -
            // Not specified in original code
            throw new IllegalArgumentException("Invalid input format: " + input);
        }
    }
}