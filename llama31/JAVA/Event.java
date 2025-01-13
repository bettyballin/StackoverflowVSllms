import java.lang.String;
public class Event {
    private long time;
    private int originalIndex;

    public Event(long time, int originalIndex) {
        this.time = time;
        this.originalIndex = originalIndex;
    }

    public long getTime() {
        return time;
    }

    public int getOriginalIndex() {
        return originalIndex;
    }

	public static void main(String[] args) {
	}
}