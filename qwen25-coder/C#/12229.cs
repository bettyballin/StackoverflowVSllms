using System;\nusing System.Diagnostics;\n\nclass Program\n{\n    static void Main()\n    {\n        Process process = GetProcessByIdOrName(); // Assume this method returns a valid Process object\n\n        if (!process.HasExited)\n        {\n            Console.WriteLine("The process is currently running.");\n        }\n        else\n        {\n            Console.WriteLine("The process has exited.");\n        }\n    }\n\n    static Process GetProcessByIdOrName()\n    {\n        // Example: Get a Process by ID or Name\n        return Process.GetProcessesByName("notepad").FirstOrDefault() ?? throw new InvalidOperationException("Process not found");\n    }\n}