using System;\nusing System.Security.Cryptography;\n\npublic class SessionTokenGenerator\n{\n    public static string GenerateSessionId()\n    {\n        byte[] randomBytes = new byte[16]; // 128 bits\n        using (var rng = RandomNumberGenerator.Create())\n        {\n            rng.GetBytes(randomBytes);\n        }\n        return Convert.ToBase64String(randomBytes).Replace('+', '-').Replace('/', '_').TrimEnd('=');\n    }\n}