import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;

import com.sun.jna.Pointer;
import com.sun.jna.platform.win32.Kernel32;
import com.sun.jna.platform.win32.WinNT;

public class ProcessKiller {
    public static void main(String[] args) throws IOException, InterruptedException {
        // Start the process as you did in Groovy
        Process proc = Runtime.getRuntime().exec("cmd /c groovy BillingServer.groovy", null, new File("C:\\"));

        // Assuming you need to wait a bit before killing it for demonstration purposes
        Thread.sleep(5000);

        // Try to destroy the process
        proc.destroy();

        // Check if the process is still alive after calling destroy()
        if (proc.isAlive()) {
            // Forcefully kill the process by PID using taskkill command in Windows
            String pid = getProcessId(proc);
            Process taskKill = Runtime.getRuntime().exec("taskkill /F /PID " + pid);
            taskKill.waitFor();
        }
    }

    private static String getProcessId(Process proc) {
        // This relies on internal structure of ProcessImpl class in Windows.
        // This is not guaranteed to work with future Java versions or non-Windows OSes.
        try {
            Field f = proc.getClass().getDeclaredField("handle");
            f.setAccessible(true);
            long handle = f.getLong(proc);

            WinNT.HANDLE phandle = new WinNT.HANDLE();
            phandle.setPointer(Pointer.createConstant(handle));

            return String.valueOf(Kernel32.INSTANCE.GetProcessId(phandle));
        } catch (Exception e) {
            throw new RuntimeException("Failed to get process ID.", e);
        }
    }
}