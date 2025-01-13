using System;\nusing System.Diagnostics;\n\nclass NetworkDriveMapper {\n    public static void MapNetworkDrive(string driveLetter, string networkPath, string username, string password) {\n        Process netUseProcess = new Process();\n        netUseProcess.StartInfo.FileName = "net.exe";\n        // Note: This example uses a plain text password for demonstration purposes.\n        // In production, avoid using plain text passwords and consider alternative approaches.\n        netUseProcess.StartInfo.Arguments = $"use {driveLetter}: \"{networkPath}\" /user:{username} {password} /persistent:yes";\n        netUseProcess.StartInfo.CreateNoWindow = true;\n        netUseProcess.Start();\n        netUseProcess.WaitForExit();\n    }\n}\n\nclass Program {\n    static void Main() {\n        // Example usage\n        string driveLetter = "Z:";\n        string networkPath = @"\\server\share";\n        string username = @"domain\user";\n        string password = "password"; // Insecure; avoid using plain text passwords in real applications\n\n        NetworkDriveMapper.MapNetworkDrive(driveLetter, networkPath, username, password);\n    }\n}