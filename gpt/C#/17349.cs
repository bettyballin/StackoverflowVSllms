public void GetRecordsByTableName(string tableName)\n{\n    // Sanitize the table name to prevent SQL injection\n    if (string.IsNullOrWhiteSpace(tableName) || !IsValidTableName(tableName))\n    {\n        throw new ArgumentException("Invalid table name.", nameof(tableName));\n    }\n\n    string sql = $"SELECT * FROM [{tableName}]";\n    var records = dataContext.ExecuteQuery<object>(sql).ToList();\n    \n    ViewData["recordsByTableName"] = records;\n}\n\nprivate bool IsValidTableName(string tableName)\n{\n    // Implement basic validation logic for table names\n    // For example, check against a list of allowed table names or use a regex\n    var allowedTableNames = new List<string> { "Table1", "Table2", "Table3" };\n    return allowedTableNames.Contains(tableName);\n}