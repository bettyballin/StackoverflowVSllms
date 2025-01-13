using System;\nusing System.Collections.Generic;\nusing System.Security.Cryptography;\nusing System.Text;\n\npublic class Program\n{\n    public static void Main()\n    {\n        List<Guid> guids = new List<Guid> \n        {\n            Guid.NewGuid(),\n            Guid.NewGuid(),\n            Guid.NewGuid()\n        };\n\n        string hash = HashGuids(guids);\n        Console.WriteLine(hash);\n    }\n\n    public static string HashGuids(List<Guid> guids)\n    {\n        using (MD5 md5 = MD5.Create())\n        {\n            // Concatenate all GUIDs as strings\n            StringBuilder concatenatedGuids = new StringBuilder();\n            foreach (Guid guid in guids)\n            {\n                concatenatedGuids.Append(guid.ToString());\n            }\n            \n            // Compute the MD5 hash of the concatenated string\n            byte[] hashBytes = md5.ComputeHash(Encoding.UTF8.GetBytes(concatenatedGuids.ToString()));\n            \n            // Convert the byte array to a hexadecimal string\n            StringBuilder hashString = new StringBuilder();\n            foreach (byte b in hashBytes)\n            {\n                hashString.Append(b.ToString("x2"));\n            }\n\n            return hashString.ToString();\n        }\n    }\n}