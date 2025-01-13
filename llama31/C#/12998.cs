using System.ServiceProcess;\n\nclass Program\n{\n    static void Main(string[] args)\n    {\n        if (Environment.UserInteractive)\n        {\n            // Running as a regular executable\n            Console.WriteLine("Running as console application");\n            Console.ReadLine();\n        }\n        else\n        {\n            // Running as a Windows service\n            ServiceBase[] ServicesToRun;\n            ServicesToRun = new ServiceBase[]\n            {\n                new MyService()\n            };\n            ServiceBase.Run(ServicesToRun);\n        }\n    }\n}\n\npublic class MyService : ServiceBase\n{\n    public MyService()\n    {\n        ServiceName = "MyService";\n    }\n\n    protected override void OnStart(string[] args)\n    {\n        // Start the service\n    }\n\n    protected override void OnStop()\n    {\n        // Stop the service\n    }\n}