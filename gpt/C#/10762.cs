using System;\nusing System.Linq;\nusing System.Collections.Generic;\n\npublic class Program\n{\n    public static void Main()\n    {\n        var list = new List<(int Id, string Name)>\n        {\n            (1, "Alice"),\n            (2, "Bob"),\n            (2, "Charlie"),\n            (3, "Dave")\n        };\n\n        var sortedList = list.OrderBy(item => item.Id).ToList();\n\n        foreach (var item in sortedList)\n        {\n            Console.WriteLine($"{item.Id} - {item.Name}");\n        }\n    }\n}