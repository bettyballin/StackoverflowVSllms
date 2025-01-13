using System;\nusing System.Reflection;\n\npublic class DynamicMethodInvoker\n{\n    public static Delegate CreateDelegate(string methodName, Type targetType)\n    {\n        // Get the method info from the type based on the method name\n        MethodInfo methodInfo = targetType.GetMethod(methodName);\n\n        if (methodInfo == null)\n        {\n            throw new ArgumentException($"Method {methodName} not found in type {targetType.Name}");\n        }\n\n        // Create a delegate that represents the method to be called dynamically\n        return Delegate.CreateDelegate(typeof(Action), methodInfo);\n    }\n}\n\n// Usage example:\nclass Program\n{\n    public static void MyMethod()\n    {\n        Console.WriteLine("MyMethod invoked!");\n    }\n\n    static void Main(string[] args)\n    {\n        string methodNameFromConfig = "MyMethod"; // This would typically come from a config source\n\n        Delegate myDelegate = DynamicMethodInvoker.CreateDelegate(methodNameFromConfig, typeof(Program));\n\n        if (myDelegate != null)\n        {\n            ((Action)myDelegate)();\n        }\n    }\n}