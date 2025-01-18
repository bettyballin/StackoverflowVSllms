import java.lang.String;
import java.time.*; // Java 8 Date and Time API

public class Main_173 {
    public static void main(String[] args) {
        Instant instant = Instant.now();
        System.out.println("Current date/time in UTC/GMT: " + instant);
    }
}