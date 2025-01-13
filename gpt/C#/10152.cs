using System;\nusing System.EnterpriseServices;\nusing System.Runtime.InteropServices;\n\n// Ensure component is registered in COM+\n[assembly: ApplicationName("MyCOMPlusApp")]\n[assembly: ApplicationActivation(ActivationOption.Server)]\n\nnamespace MyCOMComponent\n{\n    [Transaction(TransactionOption.Required)]\n    [ClassInterface(ClassInterfaceType.AutoDual)]\n    [Synchronization(SynchronizationOption.Required)]\n    [ComVisible(true)]\n    public class MyComponent : ServicedComponent\n    {\n        public void MyMethod()\n        {\n            // Your method implementation\n        }\n    }\n}