using System.ServiceProcess;\n\npublic class MyService : ServiceBase\n{\n    protected override void OnStart(string[] args)\n    {\n        // Your service start code here\n    }\n\n    protected override void OnStop()\n    {\n        // Your service stop code here\n    }\n\n    private void ConfigureServiceRestart()\n    {\n        using (var serviceController = new ServiceController("MyService"))\n        {\n            var serviceConfig = serviceController.GetServiceConfig();\n            serviceConfig.FailureActions = ServiceControllerFailureActions.Restart;\n            serviceConfig.FailureCountResetPeriod = TimeSpan.FromHours(1); // Reset failure count after 1 hour\n            serviceConfig.FirstFailure = ServiceControllerFailureActions.Restart;\n            serviceConfig.SecondFailure = ServiceControllerFailureActions.Restart;\n            serviceConfig.SubsequentFailures = ServiceControllerFailureActions.Restart;\n            serviceConfig.RestartDelay = TimeSpan.FromMinutes(1); // Restart delay\n            serviceController.ChangeServiceConfig(serviceConfig);\n        }\n    }\n}