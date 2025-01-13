using System;\nusing System.Runtime.InteropServices;\n\nclass ZOrderMonitor\n{\n    [DllImport("user32.dll")]\n    static extern IntPtr SetWinEventHook(uint eventMin, uint eventMax, IntPtr hmodWinEventProc, WinEventProc lpfnWinEventProc, uint idProcess, uint idThread, uint dwFlags);\n\n    [DllImport("user32.dll")]\n    static extern bool UnhookWinEvent(IntPtr hWinEventHook);\n\n    delegate void WinEventProc(IntPtr hWinEventHook, uint eventType, IntPtr hwnd, int idObject, int idChild, uint dwEventThread, uint dwmsEventTime);\n\n    const uint EVENT_SYSTEM_FOREGROUND = 3;\n    const uint WINEVENT_OUTOFCONTEXT = 0;\n\n    IntPtr _hook;\n\n    public ZOrderMonitor()\n    {\n        _hook = SetWinEventHook(EVENT_SYSTEM_FOREGROUND, EVENT_SYSTEM_FOREGROUND, IntPtr.Zero, OnWinEventProc, 0, 0, WINEVENT_OUTOFCONTEXT);\n    }\n\n    ~ZOrderMonitor()\n    {\n        UnhookWinEvent(_hook);\n    }\n\n    void OnWinEventProc(IntPtr hWinEventHook, uint eventType, IntPtr hwnd, int idObject, int idChild, uint dwEventThread, uint dwmsEventTime)\n    {\n        Console.WriteLine($"Z-order changed: {hwnd}");\n    }\n}