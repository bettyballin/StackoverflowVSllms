public class WTSInfo_5 {
    public static String[] WTSInfoArray = {
        "WTSInitialProgram",
        "WTSApplicationName",
        "WTSWorkingDirectory",
        "WTSOEMId",
        "WTSSessionId",
        "WTSUserName",
        "WTSWinStationName",
        "WTSDomainName",
        "WTSConnectState",
        "WTSClientBuildNumber",
        "WTSClientName",
        "WTSClientDirectory",
        "WTSClientProductId",
        "WTSClientHardwareId",
        "WTSClientAddress",
        "WTSClientDisplay",
        "WTSClientProtocolType"
    };

    public static void main(String[] args) {
        for (String info : WTSInfoArray) {
            System.out.println(info);
        }
    }
}