/*
 * Decompiled with CFR 0.152.
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ProcessKiller {
    public static boolean isProcessRunning(String string) {
        try {
            String string2;
            Process process = Runtime.getRuntime().exec("tasklist.exe");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            while ((string2 = bufferedReader.readLine()) != null) {
                if (!string2.contains(string)) continue;
                return true;
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
        return false;
    }

    public static void killProcess(String string) {
        try {
            Process process = Runtime.getRuntime().exec("taskkill /im " + string);
            process.waitFor();
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    public static void main(String[] stringArray) {
        String string = "chrome.exe";
        if (ProcessKiller.isProcessRunning(string)) {
            System.out.println("Process is running. Killing it...");
            ProcessKiller.killProcess(string);
        } else {
            System.out.println("Process is not running.");
        }
    }
}
