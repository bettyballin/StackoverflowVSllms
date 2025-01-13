using System;\nusing System.IO;\nusing System.Reflection;\n\npublic class AssemblyLoader\n{\n    public static void LoadAssembly(string assemblyName)\n    {\n        // Construct the full path to the DLL in the bin directory\n        string path = Path.Combine(AppDomain.CurrentDomain.BaseDirectory, "bin", assemblyName);\n        \n        try\n        {\n            // Load the assembly from the specified path\n            Assembly assembly = Assembly.LoadFrom(path);\n            Console.WriteLine("Assembly loaded successfully: " + assembly.FullName);\n        }\n        catch (Exception ex)\n        {\n            Console.WriteLine("Failed to load assembly: " + ex.Message);\n        }\n    }\n}