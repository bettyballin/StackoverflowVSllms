string connectionString = "Data Source=MyDatabase.sdf; Encrypt Database=True; Password=myPassword; File Mode=shared read; Persist Security Info=False;";\nusing (SqlCeEngine engine = new SqlCeEngine(connectionString))\n{\n    engine.CreateDatabase();\n}