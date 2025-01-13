using System;\nusing System.Linq;\nusing System.Text.RegularExpressions;\n\npublic class CustomPasswordGenerator\n{\n    private static readonly Random random = new Random();\n\n    public static string GeneratePassword(int length, string strengthRegex)\n    {\n        const string validChars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";\n        string password;\n        do\n        {\n            password = new string(Enumerable.Repeat(validChars, length)\n                .Select(s => s[random.Next(s.Length)]).ToArray());\n        } while (!Regex.IsMatch(password, strengthRegex));\n\n        return password;\n    }\n}\n\n// Example usage:\nstring passwordStrengthRegex = @"^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&#]).{8,}$";\nstring password = CustomPasswordGenerator.GeneratePassword(12, passwordStrengthRegex);\nConsole.WriteLine(password);