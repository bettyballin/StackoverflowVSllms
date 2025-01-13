public class Global : System.Web.HttpApplication\n{\n    protected void Application_Start(object sender, EventArgs e)\n    {\n        AppDomain.CurrentDomain.AssemblyResolve += new ResolveEventHandler(CurrentDomain_AssemblyResolve);\n    }\n\n    private static Assembly CurrentDomain_AssemblyResolve(object sender, ResolveEventArgs args)\n    {\n        // Specify the path to your DLL here\n        string dllPath = @"C:\CustomPath\YourAssembly.dll";\n\n        try\n        {\n            return Assembly.LoadFrom(dllPath);\n        }\n        catch (System.IO.FileNotFoundException)\n        {\n            // Handle file not found if necessary\n            return null;\n        }\n    }\n}