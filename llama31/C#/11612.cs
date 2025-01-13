public static string Encrypt(string input, string key)\n{\n    byte[] inputBytes = Encoding.UTF8.GetBytes(input);\n    byte[] keyBytes = Encoding.UTF8.GetBytes(key);\n    byte[] outputBytes = new byte[inputBytes.Length];\n\n    for (int i = 0; i < inputBytes.Length; i++)\n    {\n        outputBytes[i] = (byte)(inputBytes[i] ^ keyBytes[i % keyBytes.Length]);\n    }\n\n    return Convert.ToBase64String(outputBytes);\n}\n\npublic static string Decrypt(string input, string key)\n{\n    byte[] inputBytes = Convert.FromBase64String(input);\n    byte[] keyBytes = Encoding.UTF8.GetBytes(key);\n    byte[] outputBytes = new byte[inputBytes.Length];\n\n    for (int i = 0; i < inputBytes.Length; i++)\n    {\n        outputBytes[i] = (byte)(inputBytes[i] ^ keyBytes[i % keyBytes.Length]);\n    }\n\n    return Encoding.UTF8.GetString(outputBytes);\n}