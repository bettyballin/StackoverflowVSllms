using System;\nusing System.Reflection;\n\npublic class Program\n{\n    public static void PrintProperties(object obj)\n    {\n        if (obj == null)\n        {\n            Console.WriteLine("Object is null");\n            return;\n        }\n        \n        Type type = obj.GetType();\n        PropertyInfo[] properties = type.GetProperties();\n\n        Console.WriteLine($"Properties of {type.Name}:");\n        foreach (PropertyInfo property in properties)\n        {\n            object value = property.GetValue(obj);\n            Console.WriteLine($"{property.Name}: {value}");\n        }\n    }\n\n    public static void Main()\n    {\n        var example = new { Name = "Alice", Age = 30, Country = "Wonderland" };\n        PrintProperties(example);\n    }\n}