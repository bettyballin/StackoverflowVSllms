import com.sun.jna.Library;
import com.sun.jna.Native;

interface InpOut32 extends Library {
    InpOut32 INSTANCE = Native.loadLibrary("inpout32", InpOut32.class);

    void Out32(short PortAddress, short Data);
}

public class Main_724_724 {
    public static void main(String[] args) {
        InpOut32.INSTANCE.Out32((short) 0x378, (short) 0xFF); // example usage
    }
}