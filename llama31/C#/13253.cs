using System;\nusing System.Runtime.InteropServices;\n\nclass UsbHidPrinter\n{\n    [DllImport("kernel32.dll")]\n    static extern IntPtr CreateFile(string lpFileName, uint dwDesiredAccess, uint dwShareMode, IntPtr lpSecurityAttributes, uint dwCreationDisposition, uint dwFlagsAndAttributes, IntPtr hTemplateFile);\n\n    [DllImport("kernel32.dll")]\n    static extern bool WriteFile(IntPtr hFile, byte[] lpBuffer, uint nNumberOfBytesToWrite, out uint lpNumberOfBytesWritten, IntPtr lpOverlapped);\n\n    [DllImport("kernel32.dll")]\n    static extern bool CloseHandle(IntPtr hObject);\n\n    private const uint GENERIC_WRITE = 0x40000000;\n    private const uint FILE_SHARE_WRITE = 0x2;\n    private const uint CREATE_ALWAYS = 2;\n    private const uint FILE_ATTRIBUTE_NORMAL = 0x80;\n\n    public void Print(string printerName, byte[] data)\n    {\n        IntPtr handle = CreateFile($"\\\\{printerName}", GENERIC_WRITE, FILE_SHARE_WRITE, IntPtr.Zero, CREATE_ALWAYS, FILE_ATTRIBUTE_NORMAL, IntPtr.Zero);\n        if (handle != IntPtr.Zero)\n        {\n            uint written;\n            if (WriteFile(handle, data, (uint)data.Length, out written, IntPtr.Zero))\n            {\n                Console.WriteLine($"Wrote {written} bytes to printer");\n            }\n            else\n            {\n                Console.WriteLine("Error writing to printer");\n            }\n            CloseHandle(handle);\n        }\n        else\n        {\n            Console.WriteLine("Error opening printer");\n        }\n    }\n}