using System;\nusing System.Diagnostics;\nusing System.Runtime.InteropServices;\n\nclass ProcessKiller\n{\n    [DllImport("kernel32.dll", SetLastError = true)]\n    static extern bool OpenProcessToken(IntPtr hProcess, uint dwDesiredAccess, out IntPtr tokenHandle);\n\n    [DllImport("advapi32.dll", SetLastError = true)]\n    static extern bool LookupPrivilegeValue(string lpSystemName, string lpName, out LUID lpLuid);\n\n    [DllImport("kernel32.dll", SetLastError = true)]\n    static extern bool TerminateProcess(IntPtr hProcess, uint uExitCode);\n\n    [StructLayout(LayoutKind.Sequential)]\n    struct LUID\n    {\n        public uint LowPart;\n        public int HighPart;\n    }\n\n    const uint SE_DEBUG_NAME = 0x13;\n    const uint TOKEN_ADJUST_PRIVILEGES = 0x0020;\n\n    public static void KillProcess(string processName)\n    {\n        Process[] processes = Process.GetProcessesByName(processName);\n        foreach (Process p in processes)\n        {\n            IntPtr tokenHandle;\n            if (OpenProcessToken(p.Handle, TOKEN_ADJUST_PRIVILEGES, out tokenHandle))\n            {\n                LUID seDebugLuid;\n                if (LookupPrivilegeValue(null, "SeDebugPrivilege", out seDebugLuid))\n                {\n                    TOKEN_PRIVILEGES tokenPrivileges = new TOKEN_PRIVILEGES();\n                    tokenPrivileges.PrivilegeCount = 1;\n                    tokenPrivileges.Privileges[0].Attributes = SE_PRIVILEGE_ENABLED;\n                    tokenPrivileges.Privileges[0].Luid = seDebugLuid;\n                    if (AdjustTokenPrivileges(tokenHandle, false, ref tokenPrivileges, 0, IntPtr.Zero, IntPtr.Zero))\n                    {\n                        TerminateProcess(p.Handle, 0);\n                    }\n                }\n                CloseHandle(tokenHandle);\n            }\n        }\n    }\n}