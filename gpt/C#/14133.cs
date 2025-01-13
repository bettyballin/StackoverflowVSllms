using System;\nusing System.Diagnostics;\n\nclass Program\n{\n    static void Main()\n    {\n        Process process = Process.Start("notepad.exe");\n\n        // Check if the process is running\n        if (process != null && !process.HasExited)\n        {\n            Console.WriteLine("The process is running.");\n        }\n        else\n        {\n            Console.WriteLine("The process is not running.");\n        }\n\n        // Optionally wait for the process to exit\n        process.WaitForExit();\n    }\n}