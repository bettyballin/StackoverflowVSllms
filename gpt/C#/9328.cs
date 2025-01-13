using System;\nusing System.Reflection;\n\npublic class DllLoader\n{\n    public void LoadDll(string dllPath)\n    {\n        try\n        {\n            // Load the assembly from the specified path\n            Assembly assembly = Assembly.LoadFrom(dllPath);\n            \n            // Optionally, you can use the assembly here\n            // Type type = assembly.GetType("Namespace.TypeName");\n            // object instance = Activator.CreateInstance(type);\n            // MethodInfo method = type.GetMethod("MethodName");\n            // method.Invoke(instance, null);\n\n            Console.WriteLine("DLL loaded successfully from: " + dllPath);\n        }\n        catch (Exception ex)\n        {\n            Console.WriteLine("Error loading DLL: " + ex.Message);\n        }\n    }\n}