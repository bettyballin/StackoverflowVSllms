using System;\nusing System.Collections.Generic;\n\npublic class MyClass : ICloneable\n{\n    public int Value { get; set; }\n\n    public object Clone()\n    {\n        return new MyClass { Value = this.Value };\n    }\n}\n\npublic static class ListExtensions\n{\n    public static List<T> DeepClone<T>(this List<T> list) where T : ICloneable\n    {\n        List<T> clonedList = new List<T>();\n        foreach (T item in list)\n        {\n            if (item != null)\n            {\n                clonedList.Add((T)item.Clone());\n            }\n        }\n        return clonedList;\n    }\n}\n\nclass Program\n{\n    static void Main()\n    {\n        List<MyClass> originalList = new List<MyClass>\n        {\n            new MyClass { Value = 1 },\n            new MyClass { Value = 2 },\n            null // Handling null values is important\n        };\n\n        List<MyClass> clonedList = originalList.DeepClone();\n\n        foreach (var item in clonedList)\n        {\n            Console.WriteLine(item?.Value ?? "null");\n        }\n    }\n}