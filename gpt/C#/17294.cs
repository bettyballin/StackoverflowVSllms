using System;\n    using System.Runtime.InteropServices;\n    \n    namespace COMClientExample\n    {\n        class Program\n        {\n            static void Main(string[] args)\n            {\n                Type comType = Type.GetTypeFromProgID("Python.TestServer");\n                dynamic comObject = Activator.CreateInstance(comType);\n                string result = comObject.Hello("World");\n                Console.WriteLine(result);\n            }\n        }\n    }