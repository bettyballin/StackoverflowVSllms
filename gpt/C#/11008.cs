using System;\nusing System.Management;\n\nnamespace IISAppPoolMonitor\n{\n    class Program\n    {\n        static void Main(string[] args)\n        {\n            // Define the query for monitoring application pool events\n            string query = @"SELECT * FROM __InstanceModificationEvent WITHIN 10 \n                             WHERE TargetInstance ISA 'Win32_PerfFormattedData_W3SVC_AppPoolCounters'";\n\n            // Create a ManagementEventWatcher with the query\n            ManagementEventWatcher watcher = new ManagementEventWatcher(new WqlEventQuery(query));\n\n            // Subscribe to the event\n            watcher.EventArrived += new EventArrivedEventHandler(HandleEvent);\n\n            // Start listening for events\n            watcher.Start();\n\n            Console.WriteLine("Listening for IIS Application Pool events. Press any key to exit...");\n            Console.ReadKey();\n\n            // Stop listening for events\n            watcher.Stop();\n        }\n\n        private static void HandleEvent(object sender, EventArrivedEventArgs e)\n        {\n            // Extract the event details\n            var appPool = (ManagementBaseObject)e.NewEvent["TargetInstance"];\n            string appPoolName = appPool["Name"].ToString();\n            string currentState = appPool["CurrentState"].ToString();\n            \n            Console.WriteLine($"Application Pool {appPoolName} changed state to: {currentState}");\n        }\n    }\n}