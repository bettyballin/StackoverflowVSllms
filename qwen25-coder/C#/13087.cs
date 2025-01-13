using System;\nusing System.Management;\n\nclass Program\n{\n    static void Main()\n    {\n        string query = "SELECT * FROM Win32_ProcessStartTrace WHERE ProcessName=\"yourprocessname.exe\"";\n        \n        using (ManagementEventWatcher watcher = new ManagementEventWatcher(query))\n        {\n            watcher.EventArrived += OnProcessStarted;\n            watcher.Start();\n\n            Console.WriteLine("Listening for process start...");\n            Console.ReadLine(); // Keep the app running to listen for events\n        }\n    }\n\n    private static void OnProcessStarted(object sender, EventArrivedEventArgs e)\n    {\n        Console.WriteLine($"Process started: {e.NewEvent.Properties["ProcessName"].Value}");\n    }\n}