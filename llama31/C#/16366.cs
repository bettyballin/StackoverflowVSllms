using System.ServiceProcess;\n\nclass MyService : ServiceBase\n{\n    protected override void OnStart(string[] args)\n    {\n        // Your code here\n    }\n}\n\nstatic class Program\n{\n    static void Main()\n    {\n        ServiceBase[] ServicesToRun;\n        ServicesToRun = new ServiceBase[]\n        {\n            new MyService()\n        };\n        ServiceBase.Run(ServicesToRun);\n    }\n}