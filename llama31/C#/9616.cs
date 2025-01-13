using System.ServiceProcess;\n\npublic class MyService : ServiceBase\n{\n    protected override void OnStart(string[] args)\n    {\n        // Your startup code here...\n        \n        // If something goes wrong\n        if (/*some condition*/)\n        {\n            StopService();\n        }\n    }\n\n    private void StopService()\n    {\n        ServiceController controller = new ServiceController(ServiceName);\n        controller.Stop();\n    }\n}