using System;\nusing System.ServiceProcess;\nusing System.Diagnostics;\n\nnamespace ServiceProcessFinder\n{\n    class Program\n    {\n        static void Main(string[] args)\n        {\n            string serviceName = "YourServiceName"; // Replace with your service name\n            ServiceController serviceController = new ServiceController(serviceName);\n\n            try\n            {\n                foreach (Process process in Process.GetProcesses())\n                {\n                    try\n                    {\n                        if (process.MainModule.ModuleName.Equals(serviceName + ".exe", StringComparison.OrdinalIgnoreCase))\n                        {\n                            Console.WriteLine($"Process Name: {process.ProcessName}, Process ID: {process.Id}");\n                            // Here you can add code to kill the process if needed\n                            // process.Kill();\n                        }\n                    }\n                    catch (Exception ex)\n                    {\n                        // Handle any exceptions that occur while accessing process properties\n                        Console.WriteLine($"Error accessing process: {ex.Message}");\n                    }\n                }\n            }\n            catch (Exception ex)\n            {\n                // Handle any exceptions that occur while interacting with the service\n                Console.WriteLine($"Error: {ex.Message}");\n            }\n        }\n    }\n}