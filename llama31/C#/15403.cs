using System.ServiceProcess;\n\npublic class HeavyOperationService : ServiceBase\n{\n    protected override void OnStart(string[] args)\n    {\n        // Perform heavy operation here\n    }\n}