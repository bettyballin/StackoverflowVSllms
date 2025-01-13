using System;\nusing System.Diagnostics;\nusing System.Runtime.InteropServices;\n\nclass Program\n{\n    private delegate void WinEventDelegate(IntPtr hWinEventHook, uint eventType, IntPtr hwnd, int idObject, int idChild, uint dwEventThread, uint dwmsEventTime);\n    private static WinEventDelegate procDelegate = new WinEventDelegate(WinEventProc);\n\n    [DllImport("user32.dll")]\n    private static extern IntPtr SetWinEventHook(uint eventMin, uint eventMax, IntPtr hmodWinEventProc, WinEventDelegate lpfnWinEventProc, uint idProcess, uint idThread, uint dwFlags);\n\n    [DllImport("user32.dll")]\n    private static extern bool UnhookWinEvent(IntPtr hWinEventHook);\n\n    private const uint EVENT_SYSTEM_FOREGROUND = 0x0003;\n    private const uint WINEVENT_OUTOFCONTEXT = 0;\n\n    static void Main(string[] args)\n    {\n        IntPtr hWinEventHook = SetWinEventHook(EVENT_SYSTEM_FOREGROUND, EVENT_SYSTEM_FOREGROUND, IntPtr.Zero, procDelegate, 0, 0, WINEVENT_OUTOFCONTEXT);\n        \n        Console.WriteLine("Listening for foreground window changes. Press Enter to exit.");\n        Console.ReadLine();\n        \n        UnhookWinEvent(hWinEventHook);\n    }\n\n    private static void WinEventProc(IntPtr hWinEventHook, uint eventType, IntPtr hwnd, int idObject, int idChild, uint dwEventThread, uint dwmsEventTime)\n    {\n        Console.WriteLine("Foreground window changed.");\n        // Additional logic to handle the Z-order change can be added here\n    }\n}