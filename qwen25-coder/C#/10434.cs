using System;\nusing System.Collections.Generic;\nusing System.Linq;\nusing System.Diagnostics;\n\nclass ProcessController\n{\n    static void Main()\n    {\n        // Get list of all running processes\n        List<Process> runningProcesses = Process.GetProcesses().ToList();\n\n        Console.WriteLine("Running processes on this computer:");\n\n        foreach (var process in runningProcesses)\n        {\n            try\n            {\n                Console.WriteLine("{0} - ID: {1}", process.ProcessName, process.Id);\n            }\n            catch (Exception ex)\n            {\n                // Handle any exceptions that occur accessing the properties of a running process\n                Console.WriteLine("Error accessing some properties of process with ID: " + process.Id);\n            }\n        }\n\n        // Example to kill a process by name\n        string processNameToKill = "notepad";\n        if (runningProcesses.Any(p => p.ProcessName == processNameToKill))\n        {\n            Process targetProcess = runningProcesses.First(p => p.ProcessName == processNameToKill);\n            targetProcess.Kill();\n            Console.WriteLine("{0} (ID: {1}) has been terminated.", processNameToKill, targetProcess.Id);\n        }\n        else\n        {\n            Console.WriteLine("{0} is not running.", processNameToKill);\n        }\n\n        Console.ReadLine();\n    }\n}