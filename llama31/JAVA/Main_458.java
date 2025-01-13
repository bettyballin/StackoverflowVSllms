public class Main_458 {
    public static void main(String[] args) {
        String[] wtsInfo = {
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

        for (String info : wtsInfo) {
            System.out.println(info);
        }
    }
}