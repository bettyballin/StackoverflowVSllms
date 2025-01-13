using System;\nusing System.Linq;\n\nclass Program\n{\n    static void Main()\n    {\n        var items = new[]\n        {\n            new { Name = "Alice", Age = 30 },\n            new { Name = "Bob", Age = 25 },\n            new { Name = "Charlie", Age = 30 }\n        };\n\n        var sortedItems = items.OrderBy(i => i.Age).ThenBy(i => i.Name);\n\n        foreach (var item in sortedItems)\n        {\n            Console.WriteLine($"{item.Name} - {item.Age}");\n        }\n    }\n}