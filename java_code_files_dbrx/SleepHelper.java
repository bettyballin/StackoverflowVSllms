import java.lang.String;
public class SleepHelper {
    private void goToSleep(int secs) {
        try {
            Thread.sleep((long)(secs * 1000)); // convert to milliseconds
        } catch (Exception e) {}
    }

    public static void main(String[] args) {
    }
}