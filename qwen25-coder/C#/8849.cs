using System;\nusing System.CodeDom.Compiler;\nusing Microsoft.CSharp;\n\npublic class CompilerExample\n{\n    public static void Main()\n    {\n        // Create a new instance of the CSharpCodeProvider targeting version 3.0\n        var providerOptions = new Dictionary<string, string> { { "CompilerVersion", "v3.5" } };\n        CodeDomProvider codeProvider = new CSharpCodeProvider(providerOptions);\n\n        CompilerParameters compilerParams = new CompilerParameters();\n        compilerParams.GenerateExecutable = false;\n        compilerParams.OutputAssembly = "CompiledAssembly.dll";\n        // Add any necessary references\n        compilerParams.ReferencedAssemblies.Add("System.Core.dll"); // Example of additional assembly\n\n        string[] sources = { @"path\to\your\source.cs" };\n        CompilerResults results = codeProvider.CompileAssemblyFromFile(compilerParams, sources);\n\n        if (results.Errors.Count > 0)\n        {\n            foreach (CompilerError err in results.Errors)\n            {\n                Console.WriteLine($"Line {err.Line}: {err.ErrorText}");\n            }\n        }\n        else\n        {\n            Console.WriteLine("Compilation successful!");\n        }\n    }\n}