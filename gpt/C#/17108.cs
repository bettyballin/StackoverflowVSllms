using System;\nusing System.Collections.Generic;\nusing System.Linq;\n\npublic class Fruit { }\n\npublic class Banana : Fruit\n{\n    public bool IsYellow { get; set; }\n}\n\npublic class Apple : Fruit { }\n\npublic class Orange : Fruit { }\n\npublic class Program\n{\n    public static void Main()\n    {\n        List<Fruit> fruits = new List<Fruit>();\n        Banana banana1 = new Banana { IsYellow = true };\n        Banana banana2 = new Banana { IsYellow = false };\n        Apple apple1 = new Apple();\n        Orange orange1 = new Orange();\n\n        fruits.Add(banana1);\n        fruits.Add(banana2);\n        fruits.Add(apple1);\n        fruits.Add(orange1);\n\n        // Get only the bananas\n        var bananas = fruits.OfType<Banana>();\n\n        foreach (var banana in bananas)\n        {\n            Console.WriteLine(banana.IsYellow);\n        }\n    }\n}