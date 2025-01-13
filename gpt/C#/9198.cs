using System;\nusing System.Diagnostics;\n\nclass Program\n{\n    static void Main()\n    {\n        foreach (var process in Process.GetProcessesByName("winword"))\n        {\n            try\n            {\n                process.Kill();\n                process.WaitForExit(); // Optional: Wait for the process to exit\n                Console.WriteLine("winword.exe process killed.");\n            }\n            catch (Exception ex)\n            {\n                Console.WriteLine($"Error killing process: {ex.Message}");\n            }\n        }\n    }\n}