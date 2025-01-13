using System;\nusing System.Diagnostics;\n\nclass Program\n{\n    static void Main()\n    {\n        string filePath = @"path\to\your\file.txt";\n        FindProcessLockingFile(filePath);\n    }\n\n    static void FindProcessLockingFile(string filePath)\n    {\n        try\n        {\n            Process handleProcess = new Process();\n            handleProcess.StartInfo.FileName = "handle.exe";\n            handleProcess.StartInfo.Arguments = filePath;\n            handleProcess.StartInfo.UseShellExecute = false;\n            handleProcess.StartInfo.RedirectStandardOutput = true;\n            handleProcess.Start();\n\n            string output = handleProcess.StandardOutput.ReadToEnd();\n            handleProcess.WaitForExit();\n\n            Console.WriteLine(output);\n        }\n        catch (Exception ex)\n        {\n            Console.WriteLine("An error occurred: " + ex.Message);\n        }\n    }\n}