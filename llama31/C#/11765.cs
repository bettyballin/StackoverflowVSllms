using System;\nusing System.Security.Principal;\nusing System.Runtime.InteropServices;\nusing System.Diagnostics;\n\npublic class ProcessOwner\n{\n    [DllImport("advapi32.dll", SetLastError = true)]\n    static extern bool OpenProcessToken(IntPtr ProcessHandle, uint DesiredAccess, out IntPtr TokenHandle);\n\n    [DllImport("advapi32.dll", SetLastError = true)]\n    static extern bool GetTokenInformation(IntPtr TokenHandle, uint TokenInfoClass, IntPtr TokenInformation, uint TokenInformationLength, out uint ReturnLength);\n\n    [DllImport("advapi32.dll", SetLastError = true)]\n    static extern bool CloseHandle(IntPtr hObject);\n\n    const uint TOKEN_QUERY = 0x0008;\n    const uint TokenOwner = 4;\n\n    public static string GetProcessOwner(int processId)\n    {\n        IntPtr processHandle = Process.GetProcessById(processId).Handle;\n        IntPtr tokenHandle;\n        if (!OpenProcessToken(processHandle, TOKEN_QUERY, out tokenHandle))\n        {\n            throw new Exception("Could not open process token");\n        }\n\n        try\n        {\n            uint tokenInfoLength = 0;\n            IntPtr tokenInfo = IntPtr.Zero;\n            if (!GetTokenInformation(tokenHandle, TokenOwner, tokenInfo, tokenInfoLength, out tokenInfoLength))\n            {\n                if (Marshal.GetLastWin32Error() != 122) // ERROR_INSUFFICIENT_BUFFER\n                {\n                    throw new Exception("Could not get token information");\n                }\n            }\n\n            tokenInfo = Marshal.AllocHGlobal((int)tokenInfoLength);\n            if (!GetTokenInformation(tokenHandle, TokenOwner, tokenInfo, tokenInfoLength, out tokenInfoLength))\n            {\n                throw new Exception("Could not get token information");\n            }\n\n            var tokenUser = (TOKEN_USER)Marshal.PtrToStructure(tokenInfo, typeof(TOKEN_USER));\n            var sid = new SecurityIdentifier(tokenUser.User.Sid);\n            var ntAccount = (NTAccount)sid.Translate(typeof(NTAccount));\n            return ntAccount.Value;\n        }\n        finally\n        {\n            CloseHandle(tokenHandle);\n        }\n    }\n\n    [StructLayout(LayoutKind.Sequential)]\n    public struct TOKEN_USER\n    {\n        public SID_AND_ATTRIBUTES User;\n    }\n\n    [StructLayout(LayoutKind.Sequential)]\n    public struct SID_AND_ATTRIBUTES\n    {\n        public IntPtr Sid;\n        public uint Attributes;\n    }\n\n    public static void Main(string[] args)\n    {\n        int processId = Process.GetCurrentProcess().Id;\n        string owner = GetProcessOwner(processId);\n        Console.WriteLine($"Process owner: {owner}");\n    }\n}