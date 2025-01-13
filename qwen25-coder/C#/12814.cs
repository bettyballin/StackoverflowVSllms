using System;\nusing System.Management;\n\nclass RegistryWatcherService\n{\n    private ManagementEventWatcher watcher;\n    \n    public void StartWatchingRegistryKey()\n    {\n        string query = "SELECT * FROM RegistryValueChangeEvent "\n                     + "WHERE Hive='HKEY_LOCAL_MACHINE' "\n                     + "AND KeyPath='SOFTWARE\\Microsoft\\Windows\\CurrentVersion\\Run' "\n                     + "AND ValueName='MyService'"; // Change this to the path and value you want to monitor\n        \n        try\n        {\n            string queryString = "SELECT * FROM RegistryKeyChangeEvent WHERE Hive='HKEY_LOCAL_MACHINE' AND KeyPath='SOFTWARE\\\\Microsoft\\\\Windows\\\\CurrentVersion\\\\Run'";\n            \n            watcher = new ManagementEventWatcher(queryString);\n            watcher.EventArrived += OnRegistryChange;\n            \n            // Start listening for events\n            watcher.Start();\n        }\n        catch (ManagementException ex)\n        {\n            Console.WriteLine("An error occurred: " + ex.Message);\n        }\n    }\n\n    private void OnRegistryChange(object sender, EventArrivedEventArgs e)\n    {\n        Console.WriteLine("Registry key changed. Event details:");\n        foreach (PropertyData property in e.NewEvent.Properties)\n        {\n            Console.WriteLine(property.Name + ": " + property.Value);\n        }\n    }\n\n    public void StopWatching()\n    {\n        if (watcher != null)\n        {\n            watcher.Stop();\n            watcher.Dispose();\n            watcher = null;\n        }\n    }\n}\n\nclass Program\n{\n    static void Main(string[] args)\n    {\n        RegistryWatcherService service = new RegistryWatcherService();\n        service.StartWatchingRegistryKey();\n        \n        Console.WriteLine("Press any key to stop watching...");\n        Console.ReadKey();\n\n        service.StopWatching();\n    }\n}