using System;\nusing System.Linq;\nusing System.Collections.Generic;\n\nclass Program\n{\n    static void Main()\n    {\n        List<int> numbers = new List<int> { 1, 2, 3, 4, 5 };\n        var evenNumbers = numbers.Where(n => n % 2 == 0);\n\n        foreach (var number in evenNumbers)\n        {\n            Console.WriteLine(number);\n        }\n    }\n}