using System;\nusing System.CodeDom.Compiler;\nusing System.Collections.Generic;\nusing System.IO;\nusing System.Reflection;\nusing System.Security;\nusing System.Security.Permissions;\n\npublic class Sandbox\n{\n    public static void ExecuteCode(string code)\n    {\n        // Create a new permission set with limited permissions\n        PermissionSet perms = new PermissionSet(PermissionState.None);\n        perms.AddPermission(new SecurityPermission(SecurityPermissionFlag.Execution));\n        perms.AddPermission(new UIPermission(UIPermissionWindow.SafeTopLevelWindows));\n\n        // Compile the code\n        CompilerParameters cp = new CompilerParameters();\n        cp.GenerateInMemory = true;\n        cp.GenerateExecutable = false;\n        cp.TreatWarningsAsErrors = true;\n        CodeDomProvider provider = CodeDomProvider.CreateProvider("C#");\n        CompilerResults cr = provider.CompileAssemblyFromSource(cp, code);\n\n        // Check for compilation errors\n        if (cr.Errors.Count > 0)\n        {\n            throw new Exception("Compilation failed");\n        }\n\n        // Load the compiled assembly\n        Assembly assembly = cr.CompiledAssembly;\n\n        // Create a new AppDomain with the limited permission set\n        AppDomainSetup ads = new AppDomainSetup();\n        ads.ApplicationBase = Path.GetDirectoryName(assembly.Location);\n        AppDomain domain = AppDomain.CreateDomain("Sandbox", null, ads, perms, null);\n\n        // Execute the code in the sandboxed AppDomain\n        domain.ExecuteAssembly(assembly.Location, null);\n    }\n}