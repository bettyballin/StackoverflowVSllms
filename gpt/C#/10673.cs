using System;\nusing System.Text;\nusing System.Runtime.InteropServices;\n\nclass Program\n{\n    // Import necessary functions from user32.dll\n    [DllImport("user32.dll", SetLastError = true)]\n    private static extern IntPtr FindWindow(string lpClassName, string lpWindowName);\n\n    [DllImport("user32.dll", SetLastError = true)]\n    static extern bool EnumWindows(EnumWindowsProc lpEnumFunc, IntPtr lParam);\n\n    [DllImport("user32.dll", SetLastError = true)]\n    static extern int GetWindowText(IntPtr hWnd, StringBuilder lpString, int nMaxCount);\n\n    private delegate bool EnumWindowsProc(IntPtr hWnd, IntPtr lParam);\n\n    static void Main()\n    {\n        string partialTitle = "Window Title";\n        IntPtr hWnd = FindWindowByPartialTitle(partialTitle);\n\n        if (hWnd != IntPtr.Zero)\n        {\n            Console.WriteLine("Window handle found: " + hWnd);\n        }\n        else\n        {\n            Console.WriteLine("Window not found.");\n        }\n    }\n\n    private static IntPtr FindWindowByPartialTitle(string partialTitle)\n    {\n        IntPtr foundHandle = IntPtr.Zero;\n\n        EnumWindows((hWnd, lParam) =>\n        {\n            StringBuilder windowText = new StringBuilder(256);\n            GetWindowText(hWnd, windowText, windowText.Capacity);\n\n            if (windowText.ToString().StartsWith(partialTitle))\n            {\n                foundHandle = hWnd;\n                return false; // Stop enumeration\n            }\n            return true; // Continue enumeration\n        }, IntPtr.Zero);\n\n        return foundHandle;\n    }\n}