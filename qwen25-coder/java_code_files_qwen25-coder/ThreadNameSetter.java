// Using JNA to set thread names in a Windows environment
import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.WString;
import com.sun.jna.platform.win32.WinNT.HANDLE;
import com.sun.jna.platform.win32.WinNT.HRESULT;

public class ThreadNameSetter {

    public interface Kernel32 extends Library {
        Kernel32 INSTANCE = Native.load("kernel32", Kernel32.class);

        HRESULT SetThreadDescription(HANDLE hThread, WString lpThreadDescription);
        HANDLE GetCurrentThread();
    }

    public static void setNativeThreadName(String threadName) {
        try {
            Kernel32 kernel32 = Kernel32.INSTANCE;
            HANDLE handle = kernel32.GetCurrentThread();
            kernel32.SetThreadDescription(handle, new WString(threadName));
        } catch (Throwable e) {
            // Handle exceptions or log
        }
    }
}