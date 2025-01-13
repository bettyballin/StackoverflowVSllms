using System;\nusing System.IO;\nusing System.Runtime.InteropServices;\n\npublic class FileComparer\n{\n    [DllImport("kernel32.dll", SetLastError = true)]\n    private static extern bool GetFileInformationByHandle(IntPtr hFile, out BY_HANDLE_FILE_INFORMATION lpFileInformation);\n\n    [StructLayout(LayoutKind.Sequential)]\n    private struct BY_HANDLE_FILE_INFORMATION\n    {\n        public uint FileAttributes;\n        public System.Runtime.InteropServices.ComTypes.FILETIME CreationTime;\n        public System.Runtime.InteropServices.ComTypes.FILETIME LastAccessTime;\n        public System.Runtime.InteropServices.ComTypes.FILETIME LastWriteTime;\n        public uint VolumeSerialNumber;\n        public uint FileSizeHigh;\n        public uint FileSizeLow;\n        public uint NumberOfLinks;\n        public uint FileIndexHigh;\n        public uint FileIndexLow;\n    }\n\n    public static bool IsSameFile(string path1, string path2)\n    {\n        if (string.Equals(Path.GetFullPath(path1), Path.GetFullPath(path2), StringComparison.OrdinalIgnoreCase))\n        {\n            return true;\n        }\n\n        try\n        {\n            using (FileStream fs1 = new FileStream(path1, FileMode.Open, FileAccess.Read, FileShare.ReadWrite))\n            using (FileStream fs2 = new FileStream(path2, FileMode.Open, FileAccess.Read, FileShare.ReadWrite))\n            {\n                BY_HANDLE_FILE_INFORMATION fileInfo1;\n                BY_HANDLE_FILE_INFORMATION fileInfo2;\n\n                if (GetFileInformationByHandle(fs1.SafeFileHandle.DangerousGetHandle(), out fileInfo1) &&\n                    GetFileInformationByHandle(fs2.SafeFileHandle.DangerousGetHandle(), out fileInfo2))\n                {\n                    return fileInfo1.FileIndexHigh == fileInfo2.FileIndexHigh &&\n                           fileInfo1.FileIndexLow == fileInfo2.FileIndexLow &&\n                           fileInfo1.VolumeSerialNumber == fileInfo2.VolumeSerialNumber;\n                }\n            }\n        }\n        catch (Exception)\n        {\n            // Handle exception accordingly\n        }\n\n        return false;\n    }\n}\n\n// Usage\nclass Program\n{\n    static void Main()\n    {\n        string path1 = @"C:\path\to\file1.txt";\n        string path2 = @"C:\path\to\file2.txt";\n\n        bool sameFile = FileComparer.IsSameFile(path1, path2);\n        Console.WriteLine(sameFile ? "The paths refer to the same file." : "The paths refer to different files.");\n    }\n}