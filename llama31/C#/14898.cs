using System;\nusing System.Runtime.InteropServices;\n\n// Import the COM interface\n[ComImport, Guid("12345678-1234-1234-1234-123456789012")]\npublic interface IMyComInterface\n{\n    void MyMethod();\n}\n\nclass Program\n{\n    static void Main(string[] args)\n    {\n        // Create an instance of the COM component\n        var comComponent = new MyComComponent();\n\n        // Use the COM interface\n        var comInterface = (IMyComInterface)comComponent;\n        comInterface.MyMethod();\n    }\n}