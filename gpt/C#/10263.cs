using System;\nusing System.Diagnostics;\nusing System.Runtime.InteropServices;\nusing System.Threading;\n\nclass Program\n{\n    [DllImport("user32.dll")]\n    private static extern bool SetForegroundWindow(IntPtr hWnd);\n\n    [DllImport("user32.dll")]\n    private static extern bool ShowWindow(IntPtr hWnd, int nCmdShow);\n\n    private const int SW_RESTORE = 9;\n\n    static void Main()\n    {\n        using (Mutex mutex = new Mutex(true, "MyUniqueAppId", out bool createdNew))\n        {\n            if (!createdNew)\n            {\n                Process currentProcess = Process.GetCurrentProcess();\n                foreach (Process proc in Process.GetProcessesByName(currentProcess.ProcessName))\n                {\n                    if (proc.Id != currentProcess.Id)\n                    {\n                        SetForegroundWindow(proc.MainWindowHandle);\n                        ShowWindow(proc.MainWindowHandle, SW_RESTORE);\n                        return;\n                    }\n                }\n            }\n            // Your application logic here\n        }\n    }\n}