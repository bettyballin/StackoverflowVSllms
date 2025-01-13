using System;\nusing System.Threading.Tasks;\nusing Vintasoft.WpfTwain;\n\nclass Program\n{\n    private static DeviceManager _deviceManager;\n    private static Device _device;\n\n    static void Main(string[] args)\n    {\n        // Initialize device manager\n        _deviceManager = new DeviceManager();\n        _deviceManager.Open();\n\n        // Select a scanner (for demonstration purposes, we'll use the first one available)\n        if (_deviceManager.Devices.Count > 0)\n        {\n            _device = _deviceManager.Devices[0];\n            _device.Open();\n\n            // Subscribe to scan events\n            _device.AcquireCompleted += Device_AcquireCompleted;\n\n            Console.WriteLine("Waiting for scanning...");\n            Console.ReadLine();  // Keep the application running\n\n            _device.Close();\n        }\n        else\n        {\n            Console.WriteLine("No scanner found.");\n        }\n\n        _deviceManager.Close();\n    }\n\n    private static void Device_AcquireCompleted(object sender, AcquireCompletedEventArgs e)\n    {\n        if (e.IsCompletedWithoutErrors)\n        {\n            foreach (DeviceEvent eventItem in e.Events)\n            {\n                // Process scanned images\n                Console.WriteLine("Scanned image acquired. Processing now...");\n                // Logic to process the image would go here.\n            }\n        }\n        else\n        {\n            Console.WriteLine("Error during acquisition: " + e.Error.Message);\n        }\n    }\n}