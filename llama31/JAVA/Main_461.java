// Define an enum for the WTS constants
public enum WTS {
    WTSInitialProgram,
    WTSApplicationName,
    WTSWorkingDirectory,
    WTSOEMId,
    WTSSessionId,
    WTSUserName,
    WTSWinStationName,
    WTSDomainName,
    WTSConnectState,
    WTSClientBuildNumber,
    WTSClientName,
    WTSClientDirectory,
    WTSClientProductId,
    WTSClientHardwareId,
    WTSClientAddress,
    WTSClientDisplay,
    WTSClientProtocolType
}

// Example usage:
public class Main_461 {
    public static void main(String[] args) {
        // Print out the enum values
        for (WTS wts : WTS.values()) {
            System.out.println(wts);
        }
    }
}