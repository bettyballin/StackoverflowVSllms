DbProviderFactory factory = DbProviderFactories.GetFactory("System.Data.SqlClient");\n\nDataTable tables = null;\nDataSet database = new DataSet();\n\nusing (DbConnection connection = factory.CreateConnection())\n{\n\n    connection.ConnectionString = "Data Source=(local);Initial Catalog=Northwind;Integrated Security=True";\n\n    string[] restrictions = new string[4];\n\n    // Catalog\n    restrictions[0] = "Northwind";\n\n    // Owner\n    restrictions[1] = "dbo";\n\n    // Table - We want all, so null\n    restrictions[2] = null;\n\n    // Table Type - Only tables and not views\n    restrictions[3] = "BASE TABLE";\n\n    connection.Open();\n\n    // Here is my list of tables\n    tables = connection.GetSchema("Tables", restrictions);\n\n    // fill the dataset with the table data\n    foreach (DataRow table in tables.Rows)\n    {\n\n        string tableName = table["TABLE_NAME"].ToString();\n\n        DbDataAdapter adapter = factory.CreateDataAdapter();\n        DbCommand command = factory.CreateCommand();\n        command.Connection = connection;\n        command.CommandType = CommandType.Text;\n        command.CommandText = "select * from [" + tableName + "]";\n        adapter.SelectCommand = command;\n        adapter.Fill(database, tableName);\n\n    }\n\n}