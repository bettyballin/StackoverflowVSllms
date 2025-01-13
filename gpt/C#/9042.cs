using System;\nusing System.Runtime.InteropServices;\n\npublic class SessionInfo\n{\n    [DllImport("Wtsapi32.dll")]\n    private static extern bool WTSQuerySessionInformation(IntPtr hServer, int sessionId, WTS_INFO_CLASS wtsInfoClass, out IntPtr ppBuffer, out int pBytesReturned);\n\n    [DllImport("Wtsapi32.dll")]\n    private static extern void WTSFreeMemory(IntPtr pointer);\n\n    private enum WTS_INFO_CLASS\n    {\n        WTSUserName = 5,\n        WTSDomainName = 7,\n        WTSConnectState = 14,\n        WTSSessionInfo = 21\n    }\n\n    [StructLayout(LayoutKind.Sequential)]\n    private struct WTSINFO\n    {\n        public WTS_CONNECTSTATE_CLASS State;\n        public int SessionId;\n        public int IncomingBytes;\n        public int OutgoingBytes;\n        public int IncomingFrames;\n        public int OutgoingFrames;\n        public int IncomingCompressedBytes;\n        public int OutgoingCompressedBytes;\n        public SYSTEMTIME ConnectTime;\n        public SYSTEMTIME DisconnectTime;\n        public SYSTEMTIME LastInputTime;\n        public SYSTEMTIME LogonTime;\n        public SYSTEMTIME CurrentTime;\n    }\n\n    private enum WTS_CONNECTSTATE_CLASS\n    {\n        WTSActive,\n        WTSConnected,\n        WTSConnectQuery,\n        WTSShadow,\n        WTSDisconnected,\n        WTSIdle,\n        WTSListen,\n        WTSReset,\n        WTSDown,\n        WTSInit\n    }\n\n    [StructLayout(LayoutKind.Sequential)]\n    private struct SYSTEMTIME\n    {\n        public ushort Year;\n        public ushort Month;\n        public ushort DayOfWeek;\n        public ushort Day;\n        public ushort Hour;\n        public ushort Minute;\n        public ushort Second;\n        public ushort Milliseconds;\n    }\n\n    public static void GetSessionInfo()\n    {\n        IntPtr buffer = IntPtr.Zero;\n        int bytesReturned;\n\n        if (WTSQuerySessionInformation(IntPtr.Zero, WTS_CURRENT_SESSION, WTS_INFO_CLASS.WTSSessionInfo, out buffer, out bytesReturned))\n        {\n            try\n            {\n                WTSINFO sessionInfo = (WTSINFO)Marshal.PtrToStructure(buffer, typeof(WTSINFO));\n                Console.WriteLine($"Logon Time: {sessionInfo.LogonTime.Year}/{sessionInfo.LogonTime.Month}/{sessionInfo.LogonTime.Day} {sessionInfo.LogonTime.Hour}:{sessionInfo.LogonTime.Minute}:{sessionInfo.LogonTime.Second}");\n            }\n            finally\n            {\n                WTSFreeMemory(buffer);\n            }\n        }\n    }\n\n    private const int WTS_CURRENT_SESSION = -1;\n\n    public static void Main()\n    {\n        GetSessionInfo();\n    }\n}