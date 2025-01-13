using System;\nusing System.Security.Cryptography;\n\npublic class GuidGenerator\n{\n    private static readonly RandomNumberGenerator _rng = RandomNumberGenerator.Create();\n\n    public static Guid GenerateGuid()\n    {\n        byte[] bytes = new byte[16];\n        _rng.GetBytes(bytes);\n        return new Guid(bytes);\n    }\n}