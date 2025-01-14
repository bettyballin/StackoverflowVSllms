import java.lang.String;

public class Inpout32 {
    static {
        System.loadLibrary("inpout32");
    }

    public native void Out32(short portaddr, short value);
    public native int Inp32(short portaddr);

    // Wrapper methods to use the native methods safely
    public void setLED(short portAddr, boolean state) {
        if (state) {
            Out32(portAddr, (short) 0xFF);  // Set all bits high
        } else {
            Out32(portAddr, (short) 0x00);  // Set all bits low
        }
    }

    public static void main(String[] args) {
        Inpout32 io = new Inpout32();
        short portAddr = 0x378;  // Example parallel port address

        io.setLED(portAddr, true);   // Turn on LEDs
        try { Thread.sleep(1000); } catch (InterruptedException e) {}
        io.setLED(portAddr, false);  // Turn off LEDs
    }
}