using System;\nusing System.IO;\nusing System.Runtime.InteropServices;\n\nclass Program\n{\n    [DllImport("kernel32.dll", SetLastError = true)]\n    static extern bool GetVolumePathName(string lpszFileName, [Out] char[] lpszVolumePathName, uint cchBufferLength);\n\n    [DllImport("kernel32.dll", SetLastError = true)]\n    static extern bool GetVolumeInformation(\n        string lpRootPathName,\n        [Out] char[] lpVolumeNameBuffer,\n        uint nVolumeNameSize,\n        out uint lpVolumeSerialNumber,\n        out uint lpMaximumComponentLength,\n        out uint lpFileSystemFlags,\n        [Out] char[] lpFileSystemNameBuffer,\n        uint nFileSystemNameSize);\n\n    static void Main()\n    {\n        string filePath = @"\\myserver\users\brian\public\music\";\n        string volumePath = GetVolumePath(filePath);\n        uint serialNumber = GetVolumeSerialNumber(volumePath);\n\n        Console.WriteLine($"Volume Path: {volumePath}");\n        Console.WriteLine($"Volume Serial Number: {serialNumber}");\n    }\n\n    static string GetVolumePath(string filePath)\n    {\n        char[] volumePath = new char[261]; // MAX_PATH\n        if (!GetVolumePathName(filePath, volumePath, (uint)volumePath.Length))\n        {\n            throw new System.ComponentModel.Win32Exception(Marshal.GetLastWin32Error());\n        }\n        return new string(volumePath).TrimEnd('\0');\n    }\n\n    static uint GetVolumeSerialNumber(string volumePath)\n    {\n        char[] volumeName = new char[261];\n        char[] fileSystemName = new char[261];\n        uint serialNumber, maxComponentLen, fileSystemFlags;\n\n        if (!GetVolumeInformation(volumePath, volumeName, (uint)volumeName.Length, out serialNumber, out maxComponentLen, out fileSystemFlags, fileSystemName, (uint)fileSystemName.Length))\n        {\n            throw new System.ComponentModel.Win32Exception(Marshal.GetLastWin32Error());\n        }\n\n        return serialNumber;\n    }\n}