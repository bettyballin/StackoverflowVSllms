using System;\nusing System.Diagnostics;\nusing System.Runtime.InteropServices;\n\nclass Program\n{\n    [DllImport("user32.dll")]\n    static extern bool ShowWindow(IntPtr hWnd, int nCmdShow);\n\n    const int SW_RESTORE = 9;\n\n    static void Main()\n    {\n        foreach (Process proc in Process.GetProcesses())\n        {\n            if (proc.ProcessName.ToLower().StartsWith("myapp"))\n            {\n                IntPtr hWnd = proc.MainWindowHandle;\n                if (hWnd.ToInt32() == 0)\n                {\n                    // Try to get the first window handle\n                    hWnd = GetWindowHandle(proc.Id);\n                }\n\n                if (hWnd.ToInt32() != 0)\n                {\n                    ShowWindow(hWnd, SW_RESTORE);\n                    proc.CloseMainWindow();\n                    proc.WaitForExit();\n                }\n            }\n        }\n    }\n\n    static IntPtr GetWindowHandle(int processId)\n    {\n        IntPtr hWnd = IntPtr.Zero;\n        foreach (ProcessThread thread in Process.GetProcessById(processId).Threads)\n        {\n            IntPtr hThread = IntPtr.Zero;\n            try\n            {\n                hThread = OpenThread(ThreadAccess.THREAD_QUERY_INFORMATION, false, thread.Id);\n                if (hThread != IntPtr.Zero)\n                {\n                    IntPtr desktop = GetThreadDesktop(GetCurrentThreadId());\n                    if (desktop != IntPtr.Zero)\n                    {\n                        hWnd = GetTopWindow(desktop);\n                        while (hWnd != IntPtr.Zero)\n                        {\n                            uint currentProcessId;\n                            uint currentThreadId;\n                            GetWindowThreadProcessId(hWnd, out currentProcessId, out currentThreadId);\n                            if (currentProcessId == processId)\n                            {\n                                return hWnd;\n                            }\n                            hWnd = GetWindow(hWnd, GetWindowType.GW_HWNDNEXT);\n                        }\n                    }\n                }\n            }\n            finally\n            {\n                if (hThread != IntPtr.Zero)\n                {\n                    CloseHandle(hThread);\n                }\n            }\n        }\n        return hWnd;\n    }\n\n    [DllImport("user32.dll")]\n    static extern IntPtr OpenThread(ThreadAccess dwDesiredAccess, bool bInheritHandle, int dwThreadId);\n\n    [DllImport("user32.dll")]\n    static extern IntPtr GetThreadDesktop(int dwThreadId);\n\n    [DllImport("user32.dll")]\n    static extern IntPtr GetTopWindow(IntPtr hWnd);\n\n    [DllImport("user32.dll")]\n    static extern IntPtr GetWindow(IntPtr hWnd, GetWindowType wCmd);\n\n    [DllImport("user32.dll")]\n    static extern uint GetWindowThreadProcessId(IntPtr hWnd, out uint processId, out uint threadId);\n\n    [DllImport("kernel32.dll")]\n    static extern int GetCurrentThreadId();\n\n    [DllImport("kernel32.dll")]\n    static extern bool CloseHandle(IntPtr hObject);\n\n    [Flags]\n    public enum ThreadAccess : int\n    {\n        TERMINATE = (0x0001),\n        SUSPEND_RESUME = (0x0002),\n        GET_CONTEXT = (0x0008),\n        SET_CONTEXT = (0x0010),\n        SET_INFORMATION = (0x0020),\n        QUERY_INFORMATION = (0x0040),\n        SET_THREAD_PRIORITY = (0x0200),\n        GET_THREAD_PRIORITY = (0x0400),\n        JOIN_THREAD = (0x0800),\n        SET_PROCESS_INFORMATION = (0x1000)\n    }\n\n    public enum GetWindowType : uint\n    {\n        GW_HWNDFIRST = 0,\n        GW_HWNDLAST = 1,\n        GW_HWNDNEXT = 2,\n        GW_HWNDPREV = 3,\n        GW_OWNER = 4,\n        GW_CHILD = 5,\n        GW_ENABLEDPOPUP = 6\n    }\n}