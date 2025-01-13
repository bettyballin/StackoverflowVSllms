using System;\n    using System.Reflection;\n\n    object comObject = GetYourComObject();\n    Type comType = comObject.GetType();\n    \n    foreach (PropertyInfo prop in comType.GetProperties())\n    {\n        Console.WriteLine($"Property: {prop.Name}");\n    }\n\n    foreach (MethodInfo method in comType.GetMethods())\n    {\n        Console.WriteLine($"Method: {method.Name}");\n    }