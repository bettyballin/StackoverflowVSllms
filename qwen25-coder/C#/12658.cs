protected override void OnCustomCommand(int command)\n{\n    if (command == 123) // A custom command code you define\n    {\n        using (var service = new ServiceController(ServiceName))\n        {\n            service.Stop(); // Attempt to stop the service\n        }\n    }\n}