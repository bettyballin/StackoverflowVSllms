using System.Security.Cryptography;\n\npublic static string HashPassword(string password)\n{\n    using (var pbkdf2 = new Rfc2898DeriveBytes(password, 16, 10000))\n    {\n        var hash = pbkdf2.GetBytes(20);\n        return Convert.ToBase64String(hash);\n    }\n}