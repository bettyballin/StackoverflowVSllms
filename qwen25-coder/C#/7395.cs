using System;\nusing System.Runtime.InteropServices;\n\nclass Program\n{\n    [DllImport("kernel32.dll", SetLastError = true)]\n    private static extern bool QueryUserToken(uint sessionId, out IntPtr phToken);\n\n    [DllImport("wtsapi32.dll")]\n    private static extern void WTSCloseServer(IntPtr hServer);\n\n    [DllImport("wtsapi32.dll")]\n    private static extern IntPtr WTSOpenServer(string pServerName);\n\n    [DllImport("wtsapi32.dll", SetLastError = true)]\n    private static extern bool WTSEnumerateSessions(\n        IntPtr hServer,\n        IntPtr Reserved,\n        uint Version,\n        ref IntPtr ppSessionInfo,\n        ref int pCount);\n\n    [DllImport("Wtsapi32.dll")]\n    private static extern void WTSFreeMemory(IntPtr pMemory);\n\n    [DllImport("wtsapi32.dll", SetLastError = true)]\n    internal static extern bool WTSQuerySessionInformation(\n        IntPtr hServer,\n        uint sessionId,\n        WTS_INFO_CLASS wtsInfoClass,\n        out IntPtr ppBuffer,\n        out uint pBytesReturned);\n\n    private enum WTS_CONNECTSTATE_CLASS\n    {\n        WTS_ACTIVE,\n        WTS_CONNECTED,\n        WTS_CONNECTQUERY,\n        WTS_SHADOW,\n        WTS_DISCONNECTED,\n        WTS_IDLE,\n        WTS_LISTEN,\n        WTS_RESET,\n        WTS_DOWN,\n        WTS_INIT\n    }\n\n    private enum WTS_INFO_CLASS\n    {\n        WTSInitialProgram,\n        WTSApplicationName,\n        WTSClipboardAccessToken,\n        WTSWorkingDirectory,\n        WTSOEMId,\n        TSSessionId,\n        WTSUserName,\n        WTSWinStationName,\n        WTSDomainName,\n        WTSConnectState,\n        WTSClientBuildNumber,\n        WTSClientId,\n        WTSClientProtocolType,\n        WTSIdleTime,\n        WTSLogonTime,\n        WTSOEMInfo,\n        WTSPrinterName,\n        WTSWindowSize,\n        WTSClientDirectory,\n        WTSAdDomainName,\n        WTSUserNameDomain,\n        WTSSessionUserName,\n        WTSDomainNameEx,\n        WTSUserNameEx,\n        WTSProtocolType\n    }\n\n    private const int ERROR_INVALID_HANDLE_VALUE = 6;\n\n    private static DateTime GetSessionLogonTime(uint sessionId)\n    {\n        IntPtr ppBuffer;\n        uint pBytesReturned;\n        if (WTSQuerySessionInformation(IntPtr.Zero, sessionId, WTS_INFO_CLASS.WTSLogonTime, out ppBuffer, out pBytesReturned))\n        {\n            long filetime = Marshal.ReadInt64(ppBuffer);\n            DateTime dt = DateTime.FromFileTime(filetime);\n            WTSFreeMemory(ppBuffer);\n            return dt;\n        }\n        else\n        {\n            int error = Marshal.GetLastWin32Error();\n            throw new InvalidOperationException($"Failed to query session information. Error code: {error}");\n        }\n    }\n\n    static void Main(string[] args)\n    {\n        IntPtr serverHandle = WTSOpenServer(Environment.MachineName);\n        if (serverHandle == IntPtr.Zero)\n        {\n            int error = Marshal.GetLastWin32Error();\n            Console.WriteLine($"Failed to open server. Error code: {error}");\n            return;\n        }\n\n        try\n        {\n            IntPtr sessionInfoPtr;\n            int sessionCount;\n\n            bool result = WTSEnumerateSessions(serverHandle, IntPtr.Zero, 1, ref sessionInfoPtr, ref sessionCount);\n            if (!result)\n            {\n                int error = Marshal.GetLastWin32Error();\n                Console.WriteLine($"Failed to enumerate sessions. Error code: {error}");\n                return;\n            }\n\n            int currentSessionId = WTSGetActiveConsoleSessionId();\n\n            for (int i = 0; i < sessionCount; i++)\n            {\n                WTSEnumerateSessionsResponse sessionInfo = Marshal.PtrToStructure<WTSEnumerateSessionsResponse>(\n                    IntPtr.Add(sessionInfoPtr, i * Marshal.SizeOf(typeof(WTSEnumerateSessionsResponse))));\n\n                if ((WTS_CONNECTSTATE_CLASS)sessionInfo.State == WTS_CONNECTSTATE_CLASS.WTS_ACTIVE)\n                {\n                    Console.WriteLine($"Session ID: {sessionInfo.SessionId}");\n                    DateTime logonTime = GetSessionLogonTime(sessionInfo.SessionId);\n                    Console.WriteLine($"Logon Time: {logonTime}");\n                }\n            }\n\n            WTSFreeMemory(sessionInfoPtr);\n        }\n        finally\n        {\n            WTSCloseServer(serverHandle);\n        }\n    }\n\n    [StructLayout(LayoutKind.Sequential)]\n    private struct WTSEnumerateSessionsResponse\n    {\n        public uint SessionId;\n        [MarshalAs(UnmanagedType.LPStr)]\n        public string pWinStationName;\n        public WTS_CONNECTSTATE_CLASS State;\n        public IntPtr SessionFlags;\n    }\n\n    [DllImport("kernel32.dll")]\n    static extern uint WTSGetActiveConsoleSessionId();\n\n}