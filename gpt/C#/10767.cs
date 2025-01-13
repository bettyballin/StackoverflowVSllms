using System;\nusing System.Reflection;\n\nclass Program\n{\n    static void Main()\n    {\n        // Create the first AppDomain\n        AppDomain domain1 = AppDomain.CreateDomain("Domain1");\n        string assemblyPath1 = @"path\to\your\assembly1.dll"; // Path to the first version of the assembly\n        domain1.Load(AssemblyName.GetAssemblyName(assemblyPath1));\n\n        // Create the second AppDomain\n        AppDomain domain2 = AppDomain.CreateDomain("Domain2");\n        string assemblyPath2 = @"path\to\your\assembly2.dll"; // Path to the second version of the assembly\n        domain2.Load(AssemblyName.GetAssemblyName(assemblyPath2));\n\n        // Perform your data migration logic here\n\n        // Unload the AppDomains\n        AppDomain.Unload(domain1);\n        AppDomain.Unload(domain2);\n    }\n}