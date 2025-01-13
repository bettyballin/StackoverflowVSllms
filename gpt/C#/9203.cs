public class BackgroundService\n{\n    private ViewCounterService viewCounterService = new ViewCounterService();\n\n    public BackgroundService()\n    {\n        Task.Run(async () =>\n        {\n            while (true)\n            {\n                await viewCounterService.UpdateDatabaseAsync();\n                await Task.Delay(TimeSpan.FromMinutes(1)); // Adjust the interval as needed\n            }\n        });\n    }\n}