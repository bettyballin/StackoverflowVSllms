using System;\n\nclass Program\n{\n    static void Main()\n    {\n        // Example usage\n        string input = "a";\n        for (int i = 0; i < 100; i++)\n        {\n            Console.WriteLine(input);\n            input = IncrementString(input);\n        }\n    }\n\n    static string IncrementString(string input)\n    {\n        char[] charArray = input.ToCharArray();\n        for (int i = charArray.Length - 1; i >= 0; i--)\n        {\n            if (charArray[i] < 'z')\n            {\n                charArray[i]++;\n                return new string(charArray);\n            }\n            charArray[i] = 'a';\n        }\n        return new string('a', charArray.Length + 1);\n    }\n}