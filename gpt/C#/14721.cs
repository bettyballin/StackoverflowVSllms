using System;\nusing System.Management;\n\nclass Program\n{\n    static void Main()\n    {\n        string query = "SELECT * FROM RegistryValueChangeEvent WHERE Hive='HKEY_CURRENT_USER' AND KeyPath='Software\\\\YourSoftware' AND ValueName='YourValueName'";\n        ManagementEventWatcher watcher = new ManagementEventWatcher(query);\n\n        watcher.EventArrived += new EventArrivedEventHandler(OnRegistryValueChanged);\n        watcher.Start();\n\n        // Keep the application running to listen for events\n        Console.WriteLine("Watching registry key: HKEY_CURRENT_USER\\Software\\YourSoftware\\YourValueName");\n        Console.WriteLine("Press Enter to exit...");\n        Console.ReadLine();\n\n        watcher.Stop();\n    }\n\n    private static void OnRegistryValueChanged(object sender, EventArrivedEventArgs e)\n    {\n        // Logic to retrieve the old and new value\n        // Note: You'll need to manage the old value manually\n        Console.WriteLine("Registry value changed.");\n    }\n}