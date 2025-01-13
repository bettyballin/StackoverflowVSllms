using System;\nusing System.Collections.Generic;\nusing System.Text;\n\npublic class SmsEncoder\n{\n    private static Dictionary<char, byte> gsm7bitEncoding = new Dictionary<char, byte>\n    {\n        {'£', 0x9C}, // Correct hex for £ in GSM 03.38\n        // Add other special characters and their mappings here as needed\n    };\n\n    public static string EncodeToGsm7Bit(string message)\n    {\n        StringBuilder encodedMessage = new StringBuilder();\n\n        foreach (char character in message)\n        {\n            if (gsm7bitEncoding.ContainsKey(character))\n            {\n                encodedMessage.AppendFormat("{0:X2}", gsm7bitEncoding[character]);\n            }\n            else\n            {\n                byte[] charBytes = Encoding.Default.GetBytes(new char[] { character });\n                if (charBytes.Length == 1 && charBytes[0] <= 127) // Standard ASCII character\n                    encodedMessage.AppendFormat("{0:X2}", charBytes[0]);\n                else\n                    throw new ArgumentException($"Character '{character}' is not supported in GSM 03.38 encoding.");\n            }\n        }\n\n        return encodedMessage.ToString();\n    }\n\n    public static void Main()\n    {\n        string message = "Hello, this costs £10.";\n        string hexEncodedMessage = EncodeToGsm7Bit(message);\n        Console.WriteLine($"Hex Encoded Message: {hexEncodedMessage}");\n    }\n}