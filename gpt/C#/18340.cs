using System;\nusing System.Text;\n\npublic class UnicodeExample\n{\n    public static void Main()\n    {\n        string unicodeString = "Hello, 世界"; // "Hello, World" in Chinese\n        byte[] utf8Bytes = Encoding.UTF8.GetBytes(unicodeString);\n\n        Console.WriteLine("UTF-8 Bytes:");\n        foreach (byte b in utf8Bytes)\n        {\n            Console.Write($"{b:X2} ");\n        }\n\n        string decodedString = Encoding.UTF8.GetString(utf8Bytes);\n        Console.WriteLine($"\nDecoded String: {decodedString}");\n    }\n}