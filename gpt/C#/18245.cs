using System;\nusing System.Diagnostics;\nusing System.Runtime.InteropServices;\nusing System.Threading;\n\nclass Program\n{\n    private delegate IntPtr HookProc(int nCode, IntPtr wParam, IntPtr lParam);\n    private static HookProc _hookProc = HookCallback;\n    private static IntPtr _hookId = IntPtr.Zero;\n\n    static void Main(string[] args)\n    {\n        _hookId = SetWindowsHookEx(WH_CBT, _hookProc, IntPtr.Zero, GetCurrentThreadId());\n        // Call your COM DLL methods here\n        UnhookWindowsHookEx(_hookId);\n    }\n\n    private const int WH_CBT = 5;\n    private const int HCBT_ACTIVATE = 5;\n\n    private static IntPtr HookCallback(int nCode, IntPtr wParam, IntPtr lParam)\n    {\n        if (nCode == HCBT_ACTIVATE)\n        {\n            // Close the dialog immediately\n            PostMessage(wParam, WM_CLOSE, IntPtr.Zero, IntPtr.Zero);\n        }\n        return CallNextHookEx(_hookId, nCode, wParam, lParam);\n    }\n\n    [DllImport("user32.dll")]\n    private static extern IntPtr SetWindowsHookEx(int idHook, HookProc lpfn, IntPtr hMod, uint dwThreadId);\n\n    [DllImport("user32.dll")]\n    private static extern bool UnhookWindowsHookEx(IntPtr hhk);\n\n    [DllImport("user32.dll")]\n    private static extern IntPtr CallNextHookEx(IntPtr hhk, int nCode, IntPtr wParam, IntPtr lParam);\n\n    [DllImport("user32.dll")]\n    private static extern bool PostMessage(IntPtr hWnd, uint Msg, IntPtr wParam, IntPtr lParam);\n\n    [DllImport("kernel32.dll")]\n    private static extern uint GetCurrentThreadId();\n\n    private const uint WM_CLOSE = 0x0010;\n}