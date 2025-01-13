/*
 * Decompiled with CFR 0.152.
 */
import java.lang.reflect.Method;

public class BrightnessHelper {
    private static final String TAG = "BrightnessHelper";

    public static void pulseBreathingLight() {
        try {
            Object object = Class.forName("android.os.ServiceManager").getMethod("getService", String.class).invoke(null, "hardware");
            Method method = object.getClass().getMethod("pulseBreathingLight", new Class[0]);
            method.invoke(object, new Object[0]);
        }
        catch (Exception exception) {
            System.err.println("Error invoking pulseBreathingLight: " + exception.getMessage());
        }
    }

    public static void main(String[] stringArray) {
        BrightnessHelper.pulseBreathingLight();
    }
}
