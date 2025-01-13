using System.Security.Cryptography;\n\nprivate static string RandomString(int Length)\n{\n    var rng = RandomNumberGenerator.Create();\n    var bytes = new byte[Length];\n    rng.GetBytes(bytes);\n\n    return Convert.ToBase64String(bytes);\n}