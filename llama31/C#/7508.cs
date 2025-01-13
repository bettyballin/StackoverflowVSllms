static class Program\n{\n    static void Main(string[] args)\n    {\n        ServiceBase[] servicesToRun;\n        servicesToRun = new ServiceBase[] \n        { \n            new Service1() \n        };\n\n        if (Environment.UserInteractive)\n        {\n            ServiceController controller = new ServiceController("Service1");\n\n            controller.Start();\n\n            Console.WriteLine("Press any key to exit");\n            Console.Read();\n\n            controller.Stop();\n        }\n        else\n        {\n            ServiceBase.Run(servicesToRun);\n        }\n    }\n}