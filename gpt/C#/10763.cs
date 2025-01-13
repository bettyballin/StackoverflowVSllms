using System;\nusing System.Reflection;\n\npublic class Example\n{\n    public static void Main()\n    {\n        // Replace typeof(Font) with the desired type T\n        Type type = typeof(System.Drawing.Font);\n        object uninitializedObject = FormatterServices.GetUninitializedObject(type);\n        \n        // Now you have an uninitialized object of type Font\n        Console.WriteLine(uninitializedObject.GetType().FullName); // Outputs: System.Drawing.Font\n    }\n}