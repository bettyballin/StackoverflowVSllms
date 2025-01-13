using System;\n\nclass Program\n{\n    static void Main()\n    {\n        string[] myArray = { "apple", "banana", "cherry", "date", /* ... */ };\n        RandomizeArray(myArray);\n        \n        // Print the randomized array\n        foreach (string item in myArray)\n        {\n            Console.WriteLine(item);\n        }\n    }\n\n    static void RandomizeArray(string[] array)\n    {\n        Random rng = new Random();\n        int n = array.Length;\n        while (n > 1)\n        {\n            n--;\n            int k = rng.Next(n + 1);\n            string temp = array[n];\n            array[n] = array[k];\n            array[k] = temp;\n        }\n    }\n}