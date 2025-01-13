/*
 * Decompiled with CFR 0.152.
 */
public class WTSInfo_5 {
    public static String[] WTSInfoArray = new String[]{"WTSInitialProgram", "WTSApplicationName", "WTSWorkingDirectory", "WTSOEMId", "WTSSessionId", "WTSUserName", "WTSWinStationName", "WTSDomainName", "WTSConnectState", "WTSClientBuildNumber", "WTSClientName", "WTSClientDirectory", "WTSClientProductId", "WTSClientHardwareId", "WTSClientAddress", "WTSClientDisplay", "WTSClientProtocolType"};

    public static void main(String[] stringArray) {
        for (String string : WTSInfoArray) {
            System.out.println(string);
        }
    }
}
