import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.win32.StdCallLibrary;

public class NativeLibExample {

    // Interface mapping for Kernel32 library functions
    public interface Kernel32 extends StdCallLibrary {
        Kernel32 INSTANCE = (Kernel32) Native.loadLibrary("kernel32", Kernel32.class);

        Pointer LoadLibrary(String lpFileName);

        boolean FreeLibrary(Pointer hModule);
    }

    // Interface mapping for InpOut32 library functions
    public interface InpOutLib extends StdCallLibrary {
        void Out32(Pointer lib, int portAddress, int data);
        short Inp32(Pointer lib, int portAddress);
    }

    public static void main(String[] args) {
        // This maps Java classes to native resources
        Pointer lib = Kernel32.INSTANCE.LoadLibrary("inpout32");

        try {
            InpOutLib inpouts = (InpOutLib) Native.loadLibrary("inpout32", InpOutLib.class);

            // Use whatever port and data you need here, this is just a sample implementation!
            int yourInputPort = 0x501;
            int yourOutputData = 0xFD;

            inpouts.Out32(lib, yourInputPort, yourOutputData);
        } finally {
            System.out.println("Finally block executed!");
            // Unload this DLL to release resources when done using it:
            Kernel32.INSTANCE.FreeLibrary(lib);
        }
    }
}