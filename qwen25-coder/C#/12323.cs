using System;\nusing System.Collections.Generic;\nusing System.Threading;\nusing System.Management;\n\nclass Program\n{\n    private static List<string> listOfProcesses = new List<string> { "notepad", "calc" }; // Example processes to watch for\n\n    static void Main(string[] args)\n    {\n        // Set up the WMI query to listen for process start events\n        string queryString = "SELECT * FROM Win32_ProcessStartTrace";\n        \n        using (ManagementEventWatcher watcher = new ManagementEventWatcher(queryString))\n        {\n            watcher.EventArrived += Watcher_EventArrived;\n            watcher.Start();\n\n            Console.WriteLine("Listening for process creation events...");\n            \n            // Keep the application running to listen for events\n            Thread.Sleep(Timeout.Infinite);\n        }\n    }\n\n    private static void Watcher_EventArrived(object sender, EventArrivedEventArgs e)\n    {\n        string newProcessName = (string)e.NewEvent.Properties["ProcessName"].Value;\n\n        foreach (string pName in listOfProcesses)\n        {\n            if (pName.Equals(newProcessName, StringComparison.CurrentCultureIgnoreCase))\n            {\n                Console.WriteLine($"Detected process: {newProcessName}");\n                // Do some stuff here\n            }\n        }\n    }\n}