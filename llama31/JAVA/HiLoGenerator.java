import java.lang.String;
public class HiLoGenerator {
    private long hiValue; // retrieved from centralized store
    private int loValue = 1; // local, incremented for each new ID

    public synchronized long nextId() {
        long id = (hiValue << 16) + loValue;
        loValue++;
        return id;
    }

    public void updateHiValue(long newHiValue) {
        hiValue = newHiValue;
    }

	public static void main(String[] args) {
	}
}