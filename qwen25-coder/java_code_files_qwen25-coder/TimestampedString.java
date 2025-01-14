import java.lang.String;
import java.time.LocalDateTime;

public class TimestampedString implements Comparable<TimestampedString> {
    private final String value;
    private final LocalDateTime timestamp;

    public TimestampedString(String value) {
        this.value = value;
        this.timestamp = LocalDateTime.now(); // Auto-generate timestamp on creation
    }

    // Getters for value and timestamp

    @Override
    public int compareTo(TimestampedString other) {
        return this.value.compareTo(other.value); // Implementing natural ordering based on String
    }

	public static void main(String[] args) {
	}
}