using System;\nusing System.Collections.Generic;\n\npublic class Program\n{\n    public static void Main()\n    {\n        List<int> numbers = new List<int> { 1, 2, 3, 4, 5 };\n        ForEach(numbers, obj => Console.WriteLine(obj.ToString()));\n    }\n\n    public static void ForEach<T>(List<T> list, Action<T> action)\n    {\n        if (list == null || action == null)\n        {\n            throw new ArgumentNullException("List and action cannot be null");\n        }\n\n        foreach (T item in list)\n        {\n            action(item);\n        }\n    }\n}