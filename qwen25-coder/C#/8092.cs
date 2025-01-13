using System;\nusing System.Runtime.InteropServices;\n\nnamespace MyComLibrary\n{\n    // Make the entire assembly COM-visible.\n    [assembly: ComVisible(true)]\n\n    // Define a GUID for your public interfaces or types.\n    [Guid("YOUR-GUID-HERE")]\n    public interface IMyInterface\n    {\n        void MyMethod();\n    }\n\n    // Implement the interface in a class and make it ComVisible.\n    [Guid("ANOTHER-GUID-HERE")]\n    [ClassInterface(ClassInterfaceType.None)]\n    [ProgId("MyComLibrary.MyClass")]\n    public class MyClass : IMyInterface\n    {\n        public void MyMethod()\n        {\n            // Your code here.\n            Console.WriteLine("Hello from VBScript!");\n        }\n    }\n}