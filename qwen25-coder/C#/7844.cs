using System;\nusing System.Runtime.InteropServices;\n\npublic static class FilePreallocation\n{\n    [DllImport("kernel32.dll", SetLastError = true)]\n    private static extern IntPtr CreateFile(\n        string lpFileName,\n        uint dwDesiredAccess,\n        uint dwShareMode,\n        IntPtr lpSecurityAttributes,\n        uint dwCreationDisposition,\n        uint dwFlagsAndAttributes,\n        IntPtr hTemplateFile);\n\n    [DllImport("kernel32.dll", SetLastError = true)]\n    private static extern bool SetFilePointerEx(\n        IntPtr hFile,\n        long liDistanceToMove,\n        out long lpNewFilePointer,\n        int dwMoveMethod);\n\n    [DllImport("kernel32.dll", SetLastError = true)]\n    private static extern bool SetEndOfFile(IntPtr hFile);\n\n    public const uint GENERIC_READ = 0x80000000;\n    public const uint GENERIC_WRITE = 0x40000000;\n    public const uint FILE_SHARE_READ = 0x00000001;\n    public const uint FILE_SHARE_WRITE = 0x00000002;\n    public const uint OPEN_EXISTING = 3;\n\n    public static void PreAllocateSpace(string filename, long size)\n    {\n        IntPtr hFile = CreateFile(filename,\n                                   GENERIC_READ | GENERIC_WRITE,\n                                   FILE_SHARE_READ | FILE_SHARE_WRITE,\n                                   IntPtr.Zero,\n                                   OPEN_EXISTING,\n                                   0,\n                                   IntPtr.Zero);\n\n        if (hFile == IntPtr.Zero || hFile.ToInt32() == -1)\n            throw new Exception("Could not open file " + filename);\n\n        try\n        {\n            long newFilePointer;\n            if (!SetFilePointerEx(hFile, size, out newFilePointer, 0))\n                throw new Exception("Failed to set file pointer");\n\n            if (!SetEndOfFile(hFile))\n                throw new Exception("Failed to set end of file");\n        }\n        finally\n        {\n            CloseHandle(hFile);\n        }\n    }\n\n    [DllImport("kernel32.dll", SetLastError = true)]\n    private static extern bool CloseHandle(IntPtr hObject);\n\n}\n\n// Usage example:\n// FilePreallocation.PreAllocateSpace(@"C:\path\to\your\file.ext", 1073741824); // preallocate 1GB