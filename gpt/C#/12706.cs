using System;\nusing System.Runtime.InteropServices;\n\npublic class CustomActions\n{\n    [DllImport("kernel32.dll")]\n    public static extern bool GetVersionEx(ref OSVERSIONINFO osVersionInfo);\n    \n    [StructLayout(LayoutKind.Sequential)]\n    public struct OSVERSIONINFO\n    {\n        public int dwOSVersionInfoSize;\n        public int dwMajorVersion;\n        public int dwMinorVersion;\n        public int dwBuildNumber;\n        public int dwPlatformId;\n        [MarshalAs(UnmanagedType.ByValTStr, SizeConst = 128)]\n        public string szCSDVersion;\n    }\n\n    public static bool IsWindowsXP()\n    {\n        OSVERSIONINFO osVersionInfo = new OSVERSIONINFO();\n        osVersionInfo.dwOSVersionInfoSize = Marshal.SizeOf(typeof(OSVERSIONINFO));\n        if (GetVersionEx(ref osVersionInfo))\n        {\n            return osVersionInfo.dwMajorVersion == 5 && osVersionInfo.dwMinorVersion == 1;\n        }\n        return false;\n    }\n\n    public static void Main()\n    {\n        if (IsWindowsXP())\n        {\n            Console.WriteLine("Running on Windows XP");\n            // Include the merge module for Tablet PC SDK 1.7\n        }\n        else\n        {\n            Console.WriteLine("Running on a newer OS");\n            // Exclude the merge module\n        }\n    }\n}