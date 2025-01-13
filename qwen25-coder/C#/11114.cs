using System;\nusing System.IO;\nusing System.Reflection;\n\npublic class DllLoader\n{\n    public AppDomain LoadDll(string dllPath, string functionsVersion)\n    {\n        // Create a new AppDomain setup with specific configuration if needed\n        var appDomainSetup = new AppDomainSetup();\n        appDomainSetup.ApplicationBase = Path.GetDirectoryName(dllPath);\n        \n        // Create the new AppDomain\n        AppDomain domain = AppDomain.CreateDomain($"Domain_{Path.GetFileNameWithoutExtension(dllPath)}");\n\n        // Load the specified functions.dll version into the domain\n        var functionsDllPath = Path.Combine(appDomainSetup.ApplicationBase, $"Functions.{functionsVersion}.dll");\n        if (File.Exists(functionsDllPath))\n        {\n            domain.Load(AssemblyName.GetAssemblyName(functionsDllPath).FullName);\n        }\n\n        // Optionally load the DLL itself\n        domain.Load(AssemblyName.GetAssemblyName(dllPath).FullName);\n\n        return domain;\n    }\n}\n\npublic class Program\n{\n    public static void Main(string[] args)\n    {\n        DllLoader loader = new DllLoader();\n\n        string appDomain1 = loader.LoadDll("DLLS/EXAMPLEDLL1/EXAMPLEDLL1.DLL", "1.1").FriendlyName;\n        string appDomain2 = loader.LoadDll("DLLS/EXAMPLEDLL2/EXAMPLEDLL2.DLL", "1.0").FriendlyName;\n        string appDomain3 = loader.LoadDll("DLLS/EXAMPLEDLL3/EXAMPLEDLL3.DLL", "1.2").FriendlyName;\n\n        Console.WriteLine($"Loaded EXAMPLEDLL1 into {appDomain1}");\n        Console.WriteLine($"Loaded EXAMPLEDLL2 into {appDomain2}");\n        Console.WriteLine($"Loaded EXAMPLEDLL3 into {appDomain3}");\n\n        // Unloading domains if needed\n        AppDomain.Unload(AppDomain.CurrentDomain.GetDomain(appDomain1));\n        AppDomain.Unload(AppDomain.CurrentDomain.GetDomain(appDomain2));\n        AppDomain.Unload(AppDomain.CurrentDomain.GetDomain(appDomain3));\n    }\n}