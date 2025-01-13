using System;\nusing System.Linq;\n\npublic class Program\n{\n    public static void Main()\n    {\n        string[] array = { "apple", "banana", "cherry", "date", "elderberry", "fig", "grape" };\n        \n        Random random = new Random();\n        string[] randomizedArray = array.OrderBy(x => random.Next()).ToArray();\n        \n        foreach (var item in randomizedArray)\n        {\n            Console.WriteLine(item);\n        }\n    }\n}