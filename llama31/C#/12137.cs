string tableName = "MyTable";\nstring query = $"SELECT * FROM {tableName}";\nSqlCommand command = new SqlCommand(query, connection);