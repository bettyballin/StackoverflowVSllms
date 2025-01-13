using System.ServiceProcess;\n\npublic class ServiceRegistrar\n{\n    public void RegisterService(string serviceName, string executablePath)\n    {\n        ServiceController sc = new ServiceController(serviceName);\n        if (sc.Status == ServiceControllerStatus.Stopped)\n        {\n            ServiceInstaller si = new ServiceInstaller();\n            si.ServiceName = serviceName;\n            si.StartType = ServiceStartMode.Automatic;\n            si.Description = "Your service description";\n            si.DisplayName = serviceName;\n\n            ServiceProcessInstaller spi = new ServiceProcessInstaller();\n            spi.Account = ServiceAccount.LocalSystem;\n            spi.Password = null;\n            spi.Username = null;\n\n            ServiceInstallerCollection sic = new ServiceInstallerCollection();\n            sic.Add(si);\n\n            using (ServiceController controller = new ServiceController(serviceName))\n            {\n                controller.Install(sic);\n            }\n        }\n    }\n}