import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.platform.win32.Netapi32;
import com.sun.jna.platform.win32.WinNT;

public class LocalUsers {
    public static void main(String[] args) {
        Netapi32 netapi32 = (Netapi32) Native.loadLibrary("netapi32", Netapi32.class);
        Pointer buffer = new Pointer();
        int bufferSize = 1024;
        netapi32.NetUserEnum(null, 0, 0, buffer, bufferSize, null, null);
        System.out.println(buffer.getString(0));
    }
}