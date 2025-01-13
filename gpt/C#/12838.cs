using System;\nusing System.Reflection;\n\nclass Program\n{\n    static void Main()\n    {\n        // Load a private assembly (located in the application's directory)\n        string privateDllPath = @"path\to\private\assembly.dll";\n        Assembly privateAssembly = Assembly.LoadFrom(privateDllPath);\n        Console.WriteLine("Private Assembly Loaded: " + privateAssembly.FullName);\n\n        // Load a shared assembly from the GAC\n        string assemblyName = "System.Data, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089";\n        Assembly sharedAssembly = Assembly.Load(assemblyName);\n        Console.WriteLine("Shared Assembly Loaded: " + sharedAssembly.FullName);\n    }\n}