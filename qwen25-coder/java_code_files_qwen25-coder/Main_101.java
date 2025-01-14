// Example in Java: Storing current time in UTC

import java.time.ZonedDateTime;
import java.time.ZoneOffset;

public class Main {
    public static void main(String[] args) {
        ZonedDateTime utcTime = ZonedDateTime.now(ZoneOffset.UTC);
    }
}