using System.Configuration;\nusing System.ServiceProcess;\nusing System.ComponentModel;\n\n[RunInstaller(true)]\npublic class Blah : Installer\n{\n    public Blah()\n    {\n        ServiceProcessInstaller serviceProcessInstaller = new ServiceProcessInstaller();\n        ServiceInstaller serviceInstaller = new ServiceInstaller();\n\n        // Retrieve the username and password from the app.config\n        string username = ConfigurationManager.AppSettings["ServiceProcessUsername"];\n        string password = ConfigurationManager.AppSettings["ServiceProcessPassword"];\n\n        serviceProcessInstaller.Account = ServiceAccount.User;\n        serviceProcessInstaller.Username = username;\n        serviceProcessInstaller.Password = password;\n\n        // Configure the ServiceInstaller properties as needed\n        serviceInstaller.ServiceName = "YourServiceName";\n        serviceInstaller.DisplayName = "Your Service Display Name";\n        serviceInstaller.StartType = ServiceStartMode.Manual;\n\n        // Add installers to the Installers collection\n        Installers.Add(serviceProcessInstaller);\n        Installers.Add(serviceInstaller);\n    }\n}