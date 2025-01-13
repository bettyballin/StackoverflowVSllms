using System;\nusing System.Reflection;\n\npublic class Loader : MarshalByRefObject\n{\n    public void Execute(string assemblyPath)\n    {\n        Assembly assembly = Assembly.LoadFrom(assemblyPath);\n        Type type = assembly.GetType("Namespace.ClassName"); // Replace with actual type name\n        MethodInfo method = type.GetMethod("MethodName"); // Replace with actual method name\n        object instance = Activator.CreateInstance(type);\n        method.Invoke(instance, null);\n    }\n}\n\npublic class Program\n{\n    public static void Main()\n    {\n        LoadAndExecute(@"path\to\EXAMPLEDLL1\EXAMPLEDLL1.DLL", @"path\to\EXAMPLEDLL1");\n        LoadAndExecute(@"path\to\EXAMPLEDLL2\EXAMPLEDLL2.DLL", @"path\to\EXAMPLEDLL2");\n        LoadAndExecute(@"path\to\EXAMPLEDLL3\EXAMPLEDLL3.DLL", @"path\to\EXAMPLEDLL3");\n    }\n\n    public static void LoadAndExecute(string dllPath, string baseDirectory)\n    {\n        AppDomainSetup domainSetup = new AppDomainSetup\n        {\n            ApplicationBase = baseDirectory\n        };\n\n        AppDomain newDomain = AppDomain.CreateDomain("NewDomain", null, domainSetup);\n\n        Loader loader = (Loader)newDomain.CreateInstanceAndUnwrap(\n            typeof(Loader).Assembly.FullName, typeof(Loader).FullName);\n\n        loader.Execute(dllPath);\n\n        AppDomain.Unload(newDomain);\n    }\n}