// Create a new AppDomain for the .NET 1.1 runtime\nvar appDomainSetup = new AppDomainSetup();\nappDomainSetup.ApplicationBase = "path/to/net11/assemblies";\nvar appDomain = AppDomain.CreateDomain("Net11Domain", null, appDomainSetup);\n\n// Load the .NET 1.1 assembly in the new AppDomain\nvar assembly = appDomain.Load("MyNet11Assembly");