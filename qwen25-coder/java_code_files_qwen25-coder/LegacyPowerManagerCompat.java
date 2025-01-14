import java.lang.String;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class LegacyPowerManagerCompat {
    public static void main(String[] args) {
        boolean isScreenOn;
        PowerManager powerManager = new PowerManager();

        // Example: Using deprecated APIs on older Android versions
        try {
            // Attempt to use newer Android API if available
            Class<?> powerManagerService = Class.forName("android.os.PowerManager");
            Method newMethod = powerManagerService.getMethod("isInteractive");
            isScreenOn = (Boolean) newMethod.invoke(powerManager);
        } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            // Fallback to deprecated method for older Android versions
            isScreenOn = powerManager.isScreenOn();
        }
    }

    static class PowerManager {
        public boolean isScreenOn() {
            return true;
        }
    }
}