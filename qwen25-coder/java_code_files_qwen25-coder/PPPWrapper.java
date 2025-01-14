public class PPPWrapper {
    static {
        System.loadLibrary("pppwrapper"); // Load shared library into JVM
    }

    public native void sendPPPFrame(byte[] data); // Native method linked to C/C++ implementation

    public native byte[] receivePPPFrame(); // Native method linked to C/C++ implementation

    public static void main(String[] args) {
        PPPWrapper wrapper = new PPPWrapper();
        wrapper.sendPPPFrame(new byte[]{0x7E, 0xFF, 0x03, 0x21, 0x00});
        byte[] receivedData = wrapper.receivePPPFrame(); // Handle response
    }
}