import com.sun.jna.Library;
import com.sun.jna.Native;

public class SmartInfo {
    public interface Smartctl extends Library {
        Smartctl INSTANCE = Native.loadLibrary("smartctl", Smartctl.class);

        String getSmartData(String device);
    }

    public static void main(String[] args) {
        // Get the S.M.A.R.T. data for the first disk
        String data = Smartctl.INSTANCE.getSmartData("/dev/sda");

        // Parse the output to extract the temperature
        String[] lines = data.split("\n");
        for (String line : lines) {
            if (line.contains("Temperature")) {
                String temperature = line.split(":")[1].trim();
                System.out.println("Temperature: " + temperature);
            }
        }
    }
}