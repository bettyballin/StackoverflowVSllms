import java.lang.String;
public class SessionHash {
    public static long generateHash(String userId, long timestamp, String ipAddress) {
        long hash = 0;
        hash ^= userId.hashCode() << 32;
        hash ^= timestamp;
        hash ^= ipAddress.hashCode() & 0xFFFFFFFFL;
        hash = (hash << 13) & 0xFFFFFFFFFFFFFFFFL;
        return hash;
    }

	public static void main(String[] args) {
	}
}