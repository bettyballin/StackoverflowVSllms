using System;\n\nclass Program\n{\n    static void Main()\n    {\n        bool[] booleans = new bool[8];\n        Console.WriteLine($"Size of bool array: {booleans.Length * sizeof(bool)} bytes"); // Outputs 8 bytes\n    }\n}