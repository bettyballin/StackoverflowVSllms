public interface IDatabaseConfig\n{\n    string GetConnectionString();\n}\n\npublic interface ILoggingConfig\n{\n    string GetLoggingLevel();\n}