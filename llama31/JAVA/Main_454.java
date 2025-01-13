public enum WTSInfo {
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

public class Main_454 {
    public static void main(String[] args) {
        // You can access the enum values like this:
        WTSInfo info = WTSInfo.WTSInitialProgram;
        System.out.println(info);
    }
}