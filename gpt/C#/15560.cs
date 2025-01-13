using System;\nusing System.Data.SqlServerCe;\n\npublic class Program\n{\n    public static void Main()\n    {\n        string connectionString = "Data Source=|DataDirectory|\\YourDatabase.sdf;Persist Security Info=False;";\n        string tableName = "YourTableName";\n\n        using (SqlCeConnection connection = new SqlCeConnection(connectionString))\n        {\n            connection.Open();\n            string query = $"SELECT COUNT(*) FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_NAME = '{tableName}'";\n\n            using (SqlCeCommand command = new SqlCeCommand(query, connection))\n            {\n                int tableCount = (int)command.ExecuteScalar();\n                bool tableExists = tableCount > 0;\n\n                Console.WriteLine(tableExists ? "Table exists." : "Table does not exist.");\n            }\n        }\n    }\n}