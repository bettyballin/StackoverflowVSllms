var childType = typeof(ChildClass);\nvar propertyInfo = childType.GetProperty("TempProperty");\n\nif (propertyInfo != null)\n{\n    var methodInfo = propertyInfo.GetGetMethod();\n    if (methodInfo.IsHideBySig)\n    {\n        Console.WriteLine("TempProperty is hiding an inherited member");\n    }\n}