using System;\nusing System.Collections;\nusing System.Collections.Generic;\n\npublic class Program\n{\n    public static void Main()\n    {\n        var list = new List<int> { 1, 2, 3 };\n        var nonList = new int[3];\n\n        Console.WriteLine(IsGenericList(list)); // True\n        Console.WriteLine(IsGenericList(nonList)); // False\n    }\n\n    public static bool IsGenericList(object obj)\n    {\n        if (obj == null)\n        {\n            return false;\n        }\n\n        var type = obj.GetType();\n        if (!type.IsGenericType)\n        {\n            return false;\n        }\n\n        var genericTypeDefinition = type.GetGenericTypeDefinition();\n        return genericTypeDefinition == typeof(List<>);\n    }\n}