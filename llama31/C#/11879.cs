using System.Collections.Generic;\nusing System.Collections.ObjectModel;\n\npublic class Program\n{\n    public static void Main()\n    {\n        // Using List<T>\n        List<string> list = new List<string>();\n        list.Add("Item 1");\n        list.Add("Item 2");\n        list.AddRange(new[] { "Item 3", "Item 4" });\n\n        // Using Collection<T>\n        Collection<string> collection = new Collection<string>();\n        collection.Add("Item 1");\n        collection.Add("Item 2");\n        collection.CollectionChanged += (sender, args) => { /* Handle event */ };\n    }\n}