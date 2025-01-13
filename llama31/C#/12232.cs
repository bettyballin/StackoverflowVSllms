using System.ServiceProcess;\n\nnamespace MyService\n{\n    [RunInstaller(true)]\n    public class MyServiceInstaller : Installer\n    {\n        public MyServiceInstaller()\n        {\n            ServiceProcessInstaller process = new ServiceProcessInstaller();\n            process.Account = ServiceAccount.LocalSystem;\n            process.Password = null;\n            process.Username = null;\n\n            ServiceInstaller service = new ServiceInstaller();\n            service.Description = "My custom service";\n            service.DisplayName = "MyService";\n            service.ServiceName = "MyService";\n            service.StartType = ServiceStartMode.Automatic;\n\n            Installers.Add(process);\n            Installers.Add(service);\n        }\n\n        public override void Install(System.Collections.IDictionary stateSaver)\n        {\n            base.Install(stateSaver);\n            // Your .exe will be installed as a service\n        }\n    }\n}