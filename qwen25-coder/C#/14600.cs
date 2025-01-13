using System;\nusing System.Reflection;\n\nclass Program\n{\n    static void Main()\n    {\n        // Load the assembly from file\n        Assembly testDLL = Assembly.LoadFile("C:\\dll\\test.dll");\n\n        // Get type information for your specific class (e.g., "TestClass")\n        Type testType = testDLL.GetType("Namespace.TestClass");\n        \n        if (testType == null)\n        {\n            Console.WriteLine("Type not found.");\n            return;\n        }\n\n        // Create an instance of the type if it's not static\n        object testInstance = Activator.CreateInstance(testType);\n\n        // Get method information for the method you want to call (e.g., "TestMethod")\n        MethodInfo testMethod = testType.GetMethod("TestMethod");\n        \n        if (testMethod == null)\n        {\n            Console.WriteLine("Method not found.");\n            return;\n        }\n\n        // Invoke the method\n        // If there are parameters, pass them as an array in the second parameter of Invoke()\n        object result = testMethod.Invoke(testInstance, null);\n\n        // Output the result. Adjust according to your TestMethod's return type\n        Console.WriteLine("Result: " + result);\n    }\n}