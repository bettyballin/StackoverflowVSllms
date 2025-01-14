import java.lang.String;
public class RMILogger {
    public static void main(String[] args) throws Exception {
        // Enable verbose GC and RMI logging
        System.setProperty("sun.rmi.transport.tcp.logLevel", "verbose");
        
        // Add other RMI properties if necessary for debugging
        System.setProperty("java.rmi.server.logCalls", "true");

        // Your RMI code here...

    }
}