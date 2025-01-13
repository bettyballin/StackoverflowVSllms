using System;\nusing System.Runtime.InteropServices;\n\nclass IconExtractor\n{\n    [DllImport("shell32.dll")]\n    static extern int ExtractIconEx(string lpszFile, int nIconIndex, IntPtr[] phiconLarge, IntPtr[] phiconSmall, uint nIconSize);\n\n    public static IntPtr ExtractIcon(string filePath, int iconIndex)\n    {\n        IntPtr[] largeIcons = new IntPtr[1];\n        IntPtr[] smallIcons = new IntPtr[1];\n\n        int result = ExtractIconEx(filePath, iconIndex, largeIcons, smallIcons, 32);\n\n        if (result > 0)\n        {\n            return largeIcons[0];\n        }\n        else\n        {\n            return IntPtr.Zero;\n        }\n    }\n}