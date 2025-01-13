using System;\nusing System.Reflection;\n\npublic class AssemblyResolver\n{\n    public static void Resolve(object sender, ResolveEventArgs args)\n    {\n        if (args.Name == "TestFunctions, Version=1.0.0.0, Culture=neutral, PublicKeyToken=your_public_key_token")\n        {\n            string correctAssemblyPath = @"path\to\TestFunctions.dll (ver 1.0.0.1)";\n            Assembly correctAssembly = Assembly.LoadFrom(correctAssemblyPath);\n            args.ReturnValue = correctAssembly;\n        }\n    }\n}