using System;\nusing System.Security.Cryptography;\nusing System.Text;\n\npublic class PasswordHasher\n{\n    public static string HashPassword(string password, byte[] salt)\n    {\n        var pbkdf2 = new Rfc2898DeriveBytes(password, salt, 10000);\n        return Convert.ToBase64String(pbkdf2.GetBytes(256));\n    }\n\n    public static byte[] GenerateSalt()\n    {\n        using (var rng = RandomNumberGenerator.Create())\n        {\n            var salt = new byte[32];\n            rng.GetBytes(salt);\n            return salt;\n        }\n    }\n}\n\npublic class User\n{\n    public string Username { get; set; }\n    public string HashedPassword { get; set; }\n    public string Salt { get; set; }\n\n    public void SetPassword(string password)\n    {\n        var salt = PasswordHasher.GenerateSalt();\n        HashedPassword = PasswordHasher.HashPassword(password, salt);\n        Salt = Convert.ToBase64String(salt); // Store the salt in Base64\n    }\n}