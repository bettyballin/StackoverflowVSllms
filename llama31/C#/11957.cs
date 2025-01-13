using System;\nusing System.Management;\n\nclass IISMonitor\n{\n    static void Main(string[] args)\n    {\n        // Create a new WMI scope\n        ManagementScope scope = new ManagementScope("root\\MicrosoftIISv2");\n\n        // Create a new event query\n        WqlEventQuery query = new WqlEventQuery("SELECT * FROM IISApplicationPoolEvent");\n\n        // Create a new event watcher\n        ManagementEventWatcher watcher = new ManagementEventWatcher(scope, query);\n\n        // Add an event handler\n        watcher.EventArrived += new EventArrivedEventHandler(OnApplicationPoolEvent);\n\n        // Start the event watcher\n        watcher.Start();\n\n        Console.WriteLine("Press any key to exit...");\n        Console.ReadKey();\n    }\n\n    static void OnApplicationPoolEvent(object sender, EventArrivedEventArgs e)\n    {\n        // Get the event object\n        ManagementBaseObject evt = e.NewEvent;\n\n        // Get the application pool name\n        string appPoolName = (string)evt["ApplicationPoolName"];\n\n        // Get the event type\n        string eventType = (string)evt["EventType"];\n\n        Console.WriteLine($"Application pool {appPoolName} {eventType}");\n    }\n}