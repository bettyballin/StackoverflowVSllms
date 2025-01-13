public static void ListArrayListMembers(ArrayList list)\n{\n    foreach (Object obj in list)\n    {\n        Type type = obj.GetType();\n        FieldInfo[] fields = type.GetFields(BindingFlags.Public | BindingFlags.Instance);\n        foreach (FieldInfo field in fields)\n        {\n            Console.WriteLine($"{field.Name}: {field.GetValue(obj)}");\n        }\n    }\n}