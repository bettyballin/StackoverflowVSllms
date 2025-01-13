using System;\nusing System.Collections.Generic;\n\npublic class Program\n{\n    public static void Main()\n    {\n        Dictionary<string, string> myDictionary = new Dictionary<string, string>\n        {\n            { "Key1", "Value1" },\n            { "Key2", "Value2" }\n        };\n\n        // Print the dictionary contents similar to print_r in PHP\n        foreach (KeyValuePair<string, string> kvp in myDictionary)\n        {\n            Console.WriteLine($"Key: {kvp.Key}, Value: {kvp.Value}");\n        }\n    }\n}