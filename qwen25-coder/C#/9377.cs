// Logger.cs in Logger project\npublic static class Logger\n{\n    public static void Log(string message)\n    {\n        // logging logic here\n        Console.WriteLine($"Log: {message}");\n    }\n}\n\n// Validator.cs in Validator project\npublic static class Validator\n{\n    public static bool IsValidEmail(string email)\n    {\n        // validation logic here\n        return email.Contains('@') && email.Contains('.');\n    }\n}