using System;\nusing System.Diagnostics;\nusing System.Runtime.InteropServices;\n\nclass Program\n{\n    const int WM_QUERYENDSESSION = 0x1112;\n    const int WM_ENDSESSION = 0x16;\n\n    [DllImport("user32.dll", SetLastError = true)]\n    static extern IntPtr SendMessageTimeout(\n        IntPtr hWnd, uint Msg, IntPtr wParam, \n        IntPtr lParam, uint fuFlags, uint uTimeout,\n        out UIntPtr lpdwResult);\n\n    static void Main()\n    {\n        foreach (Process proc in Process.GetProcesses())\n        {\n            if (proc.ProcessName.ToLower().StartsWith("myapp"))\n            {\n                // Enumerate all windows of the process\n                EnumWindows(new EnumWindowsProc((IntPtr hWnd, IntPtr lParam) =>\n                {\n                    uint pid;\n                    GetWindowThreadProcessId(hWnd, out pid);\n                    if (pid == proc.Id)\n                    {\n                        try\n                        {\n                            UIntPtr result;\n                            SendMessageTimeout(hWnd, WM_QUERYENDSESSION, IntPtr.Zero, IntPtr.Zero, 2, 5000, out result);\n                            SendMessageTimeout(hWnd, WM_ENDSESSION,(IntPtr.One, IntPtr.Zero, 2, 5000, out result);\n                        }\n                        catch (Exception ex)\n                        {\n                            Console.WriteLine($"Error: {ex.Message}");\n                        }\n                    }\n                    return true;\n                }), IntPtr.Zero);\n\n                proc.WaitForExit(); // Wait for the process to exit gracefully\n            }\n        }\n    }\n\n    delegate bool EnumWindowsProc(IntPtr hWnd, IntPtr lParam);\n\n    [DllImport("user32.dll")]\n    [return: MarshalAs(UnmanagedType.Bool)]\n    static extern bool EnumWindows(EnumWindowsProc lpEnumFunc, IntPtr lParam);\n\n    [DllImport("user32.dll", SetLastError = true)]\n    private static extern uint GetWindowThreadProcessId(IntPtr hWnd, out uint lpdwProcessId);\n}