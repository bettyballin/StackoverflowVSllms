public static class DatabaseFactory\n{\n    public static IDatabase CreateDatabase(string dbType)\n    {\n        switch (dbType.ToLower())\n        {\n            case "sqlserver":\n                return new SqlServerDatabase();\n            case "oracle":\n                return new OracleDatabase();\n            case "mysql":\n                return new MySqlDatabase();\n            case "db2":\n                return new Db2Database();\n            default:\n                throw new ArgumentException("Invalid database type");\n        }\n    }\n}