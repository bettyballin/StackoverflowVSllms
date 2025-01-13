using System;\nusing System.Runtime.InteropServices;\n\n// Assume this is how you define an interface for the COM object\n[ComImport]\n[Guid("your-guid-here")]\n[InterfaceType(ComInterfaceType.InterfaceIsIUnknown)]\npublic interface IYourComObject\n{\n    void DoSomething();\n}\n\n// Usage in your application\npublic class ComUsageExample\n{\n    private IYourComObject comObject;\n\n    public ComUsageExample()\n    {\n        // Create an instance of the COM object\n        comObject = (IYourComObject)Activator.CreateInstance(Type.GetTypeFromProgID("YourProgId"));\n    }\n\n    public void UseComObject()\n    {\n        // Call a method on the COM object\n        comObject.DoSomething();\n\n        // Note: Any thread-local data set by the COM object won't be accessible here\n    }\n}