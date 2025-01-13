using System;\n   using System.Threading;\n\n   class Program\n   {\n       private static bool _isRunning = true;\n\n       static void Main(string[] args)\n       {\n           Console.WriteLine("Starting Service");\n\n           AppDomain.CurrentDomain.ProcessExit += (s, e) => StopService();\n           Console.CancelKeyPress += (s, e) =>\n           {\n               StopService();\n               e.Cancel = true;\n           };\n\n           StartService();\n\n           while (_isRunning)\n           {\n               Thread.Sleep(1000); // Simulate work\n           }\n\n           Console.WriteLine("Service stopped.");\n       }\n\n       private static void StartService()\n       {\n           _isRunning = true;\n           Console.WriteLine("Service is running...");\n       }\n\n       private static void StopService()\n       {\n           _isRunning = false;\n           Console.WriteLine("Stopping service...");\n       }\n   }