using System;\nusing System.Diagnostics;\nusing System.Runtime.InteropServices;\nusing System.Text;\n\nclass Program\n{\n    // Importing necessary Windows API functions\n    [DllImport("user32.dll", SetLastError = true)]\n    private static extern IntPtr FindWindow(string lpClassName, string lpWindowName);\n\n    [DllImport("user32.dll")]\n    private static extern IntPtr GetMenu(IntPtr hWnd);\n\n    [DllImport("user32.dll")]\n    private static extern bool AppendMenu(IntPtr hMenu, uint uFlags, uint uIDNewItem, string lpNewItem);\n\n    [DllImport("user32.dll")]\n    private static extern int GetMenuItemCount(IntPtr hMenu);\n\n    const uint MF_STRING = 0x0;\n\n    static void Main()\n    {\n        // Replace with Google Talk's class name and window title if known\n        IntPtr googleTalkHandle = FindWindow(null, "Google Talk");\n        if (googleTalkHandle == IntPtr.Zero)\n        {\n            Console.WriteLine("Failed to find Google Talk window.");\n            return;\n        }\n\n        IntPtr menuHandle = GetMenu(googleTalkHandle);\n        if (menuHandle == IntPtr.Zero)\n        {\n            Console.WriteLine("Failed to get the menu handle.");\n            return;\n        }\n\n        // Append a new menu item at the end\n        bool result = AppendMenu(menuHandle, MF_STRING, 0x1000, "Always Idle");\n        if (!result)\n        {\n            Console.WriteLine("Failed to append menu item. Error code: " + Marshal.GetLastWin32Error());\n        }\n        else\n        {\n            Console.WriteLine("Successfully appended menu item.");\n        }\n    }\n}