public class DatabaseConfig : IDatabaseConfig\n{\n    public string GetConnectionString()\n    {\n        return "YourConnectionString";\n    }\n}\n\npublic class LoggingConfig : ILoggingConfig\n{\n    public string GetLoggingLevel()\n    {\n        return "Debug";\n    }\n}