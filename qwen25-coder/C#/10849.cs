using System.Diagnostics;\n\nclass Program\n{\n    static void Main()\n    {\n        ProcessStartInfo start = new ProcessStartInfo();\n        start.FileName = "csc.exe";\n        start.Arguments = "/target:library yourcode.cs"; // Example arguments\n        start.UseShellExecute = false;\n        start.RedirectStandardOutput = true;\n\n        using (Process process = Process.Start(start))\n        {\n            using (System.IO.StreamReader reader = process.StandardOutput)\n            {\n                string result = reader.ReadToEnd();\n                System.Console.Write(result);\n            }\n        }\n    }\n}