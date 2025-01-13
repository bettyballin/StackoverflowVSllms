using System;\nusing System.Diagnostics;\n\npublic class ApplicationChecker\n{\n    public static bool IsProcessRunning(string processName)\n    {\n        Process[] processes = Process.GetProcessesByName(processName);\n        return processes.Length > 0;\n    }\n\n    public static void Main()\n    {\n        string serviceName = "YourServiceAppName"; // Replace with your service application name without .exe\n\n        if (!IsProcessRunning(serviceName))\n        {\n            Console.WriteLine($"{serviceName} is not running. Shutting down the current application.");\n            Environment.Exit(0);\n        }\n        else\n        {\n            Console.WriteLine($"{serviceName} is running. Proceeding with the current application.");\n        }\n    }\n}