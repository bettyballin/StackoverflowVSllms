// Create a new AppDomain for each DLL\nforeach (string dllPath in dllPaths)\n{\n    AppDomainSetup setup = new AppDomainSetup();\n    setup.ApplicationBase = Path.GetDirectoryName(dllPath);\n    AppDomain domain = AppDomain.CreateDomain("DLLDomain", null, setup);\n\n    // Load the DLL and its Functions.dll into the new AppDomain\n    domain.Load(typeof(EXAMPLEDLL1).Assembly.FullName);\n    domain.Load(typeof(Functions).Assembly.FullName);\n}