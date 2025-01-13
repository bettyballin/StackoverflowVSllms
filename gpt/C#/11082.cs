using System;\nusing System.Collections.Generic;\n\npublic class Item\n{\n    public string Number { get; set; }\n    public string Name { get; set; }\n    public List<Item> Children { get; set; } = new List<Item>();\n}\n\npublic class Program\n{\n    public static void Main()\n    {\n        var items = new List<Item>\n        {\n            new Item { Number = "1", Name = "Welcome" },\n            new Item\n            {\n                Number = "2",\n                Name = "Whats New",\n                Children = new List<Item>\n                {\n                    new Item { Number = "2.1", Name = "Gifts" },\n                    new Item { Number = "2.2", Name = "Ideas" },\n                    new Item\n                    {\n                        Number = "2.3",\n                        Name = "Others",\n                        Children = new List<Item>\n                        {\n                            new Item { Number = "2.3.1", Name = "Novelty" },\n                            new Item { Number = "2.3.2", Name = "Boats" }\n                        }\n                    },\n                    new Item { Number = "2.4", Name = "Vehicals" },\n                    new Item { Number = "2.5", Name = "Fruits" }\n                }\n            }\n        };\n\n        // Remove item "2.1 Gifts" and "2.3.1 Novelty"\n        RemoveItem(items, "2.1");\n        RemoveItem(items, "2.3.1");\n\n        // Re-number the structure\n        ReNumberItems(items, "");\n\n        // Print the result\n        PrintItems(items, 0);\n    }\n\n    public static void RemoveItem(List<Item> items, string number)\n    {\n        foreach (var item in items)\n        {\n            if (item.Number == number)\n            {\n                items.Remove(item);\n                return;\n            }\n\n            if (item.Children.Count > 0)\n            {\n                RemoveItem(item.Children, number);\n            }\n        }\n    }\n\n    public static void ReNumberItems(List<Item> items, string parentNumber)\n    {\n        int counter = 1;\n        foreach (var item in items)\n        {\n            string newNumber = parentNumber == "" ? counter.ToString() : $"{parentNumber}.{counter}";\n            item.Number = newNumber;\n\n            if (item.Children.Count > 0)\n            {\n                ReNumberItems(item.Children, newNumber);\n            }\n            counter++;\n        }\n    }\n\n    public static void PrintItems(List<Item> items, int indentLevel)\n    {\n        foreach (var item in items)\n        {\n            Console.WriteLine($"{new string(' ', indentLevel * 2)}{item.Number} {item.Name}");\n            if (item.Children.Count > 0)\n            {\n                PrintItems(item.Children, indentLevel + 1);\n            }\n        }\n    }\n}