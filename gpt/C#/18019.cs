using System;\nusing System.Collections;\n\nclass Program\n{\n    static void Main()\n    {\n        BitArray bitArray = new BitArray(8); // Creates a BitArray with 8 bits\n        bitArray[0] = true;\n        bitArray[1] = false;\n        bitArray[2] = true;\n\n        for (int i = 0; i < bitArray.Count; i++)\n        {\n            Console.WriteLine($"Bit {i}: {bitArray[i]}");\n        }\n    }\n}