using System;\nusing System.Collections.Generic;\n\nclass Program\n{\n    static void Main()\n    {\n        List<uint> numbers = new List<uint> { 12, 23, 33, 11 };\n        List<int> positionsToRemove = new List<int> { 0, 2 };\n\n        // Sort the positions in descending order to avoid index shifting\n        positionsToRemove.Sort((a, b) => b.CompareTo(a));\n\n        foreach (int position in positionsToRemove)\n        {\n            if (position >= 0 && position < numbers.Count)\n            {\n                numbers.RemoveAt(position);\n            }\n        }\n\n        Console.WriteLine(string.Join(", ", numbers)); // Output will be: 23, 11\n    }\n}