using System;\nusing Oracle.DataAccess.Client;\n\nclass OracleLiteConnection\n{\n    static void Main()\n    {\n        string connectionString = "User Id=scott;Password=tiger;Data Source=POLiteDataSource";\n        using (OracleConnection connection = new OracleConnection(connectionString))\n        {\n            connection.Open();\n            Console.WriteLine("Connected to Oracle Lite");\n            connection.Close();\n        }\n    }\n}