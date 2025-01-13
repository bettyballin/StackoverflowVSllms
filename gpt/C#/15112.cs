using System;\nusing System.Collections.Generic;\n\npublic class Example : ICloneable\n{\n    public int Value { get; set; }\n\n    public object Clone()\n    {\n        return new Example { Value = this.Value };\n    }\n}\n\npublic class Program\n{\n    public static List<T> CloneList<T>(List<T> originalList) where T : ICloneable\n    {\n        List<T> clonedList = new List<T>(originalList.Count);\n        foreach (T item in originalList)\n        {\n            clonedList.Add((T)item.Clone());\n        }\n        return clonedList;\n    }\n\n    public static void Main()\n    {\n        List<Example> originalList = new List<Example>\n        {\n            new Example { Value = 1 },\n            new Example { Value = 2 }\n        };\n\n        List<Example> clonedList = CloneList(originalList);\n\n        // Display cloned list items\n        foreach (var item in clonedList)\n        {\n            Console.WriteLine(item.Value);\n        }\n    }\n}