public static class DatabaseHelperFactory\n{\n    public static IDatabaseHelper CreateDatabaseHelper(string provider, string connectionString)\n    {\n        switch (provider.ToLower())\n        {\n            case "sqlserver":\n                return new SqlServerHelper(connectionString);\n            case "mysql":\n                return new MySqlHelper(connectionString);\n            // Add other providers here\n            default:\n                throw new ArgumentException("Invalid provider");\n        }\n    }\n}