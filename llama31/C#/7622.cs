using System.Management;\n\npublic class FolderCompressor\n{\n    public static void CompressFolder(string folderPath)\n    {\n        string objPath = "Win32_Directory.Name=\"" + folderPath + "\"";\n        using (ManagementObject dir = new ManagementObject(objPath))\n        {\n            dir.InvokeMethod("Compress", new object[] { true });\n        }\n    }\n}