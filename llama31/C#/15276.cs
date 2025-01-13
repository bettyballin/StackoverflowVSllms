[RunInstaller(true)]\npublic class MyServiceInstaller : Installer\n{\n    private ServiceProcessInstaller processInstaller;\n\n    public MyServiceInstaller()\n    {\n        processInstaller = new ServiceProcessInstaller();\n        processInstaller.Account = ServiceAccount.User;\n    }\n\n    public override void BeforeInstall(IDictionary stateSaver)\n    {\n        processInstaller.Username = "myusername";\n        processInstaller.Password = "mypassword";\n    }\n\n    public override void Install(IDictionary stateSaver)\n    {\n        base.Install(stateSaver);\n        processInstaller.Install(stateSaver);\n    }\n}