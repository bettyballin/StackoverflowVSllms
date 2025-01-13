using System;\nusing System.Drawing;\nusing System.Runtime.InteropServices;\n\nclass Program\n{\n    [DllImport("user32.dll", CharSet = CharSet.Auto)]\n    public static extern int ExtractIconEx(string lpszFile, int nIconIndex, IntPtr[] phiconLarge, IntPtr[] phiconSmall, uint nIcons);\n\n    [DllImport("user32.dll", CharSet = CharSet.Auto)]\n    public static extern bool DestroyIcon(IntPtr handle);\n\n    public static Icon ExtractIconFromFile(string filePath, int iconIndex)\n    {\n        IntPtr[] largeIcon = new IntPtr[1];\n        IntPtr[] smallIcon = new IntPtr[1];\n\n        try\n        {\n            ExtractIconEx(filePath, iconIndex, largeIcon, smallIcon, 1);\n            return largeIcon[0] != IntPtr.Zero ? Icon.FromHandle(largeIcon[0]) : null;\n        }\n        finally\n        {\n            if (largeIcon[0] != IntPtr.Zero)\n            {\n                DestroyIcon(largeIcon[0]);\n            }\n\n            if (smallIcon[0] != IntPtr.Zero)\n            {\n                DestroyIcon(smallIcon[0]);\n            }\n        }\n    }\n\n    static void Main(string[] args)\n    {\n        string dllPath = @"C:\Path\To\Your\SomeFile.dll";\n        int iconIndex = 203; // Example icon index\n\n        Icon icon = ExtractIconFromFile(dllPath, iconIndex);\n\n        if (icon != null)\n        {\n            // Save the extracted icon to a file\n            using (var stream = new System.IO.FileStream("extracted_icon.ico", System.IO.FileMode.Create))\n            {\n                icon.Save(stream);\n            }\n\n            Console.WriteLine("Icon extracted and saved successfully.");\n        }\n        else\n        {\n            Console.WriteLine("Failed to extract icon.");\n        }\n    }\n}