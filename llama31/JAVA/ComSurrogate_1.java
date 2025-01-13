import java.lang.String;
import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.platform.win32.Ole32;
import com.sun.jna.platform.win32.WinDef.HRESULT;
import com.sun.jna.platform.win32.WinDef.LPVOID;
import com.sun.jna.platform.win32.WinDef.UINT;
import com.sun.jna.platform.win32.WinNT.HANDLE;

public class ComSurrogate_1_1 {
    public static void main(String[] args) {
        // Load the Ole32 library
        Ole32 ole32 = (Ole32) Native.loadLibrary(Ole32.class);

        // Create the 32-bit COM object
        HANDLE handle = new HANDLE();
        HRESULT hr = ole32.CoCreateInstance(
            "My32BitComObject", 
            null, 
            0x00000004, // CLSCTX_ACTIVATE_32_BIT_SERVER 
            null, 
            handle.getPointer()
        );

        // Use the COM object as usual
        LPVOID comObject = handle.getPointer();
        // ...
    }
}