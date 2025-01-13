// Enum for column names\npublic enum SortColumn\n{\n    Column1,\n    Column2 // Add more columns as needed\n}\n\n// Enum for sort direction\npublic enum SortDirection\n{\n    ASC,\n    DESC\n}\n\n// Method to get the SQL column name based on enum\nprivate string GetColumnName(SortColumn column)\n{\n    switch (column)\n    {\n        case SortColumn.Column1:\n            return "Column1";\n        case SortColumn.Column2:\n            return "Column2";\n        default:\n            throw new ArgumentException("Invalid column");\n    }\n}\n\n// Method to build the SQL query\npublic string BuildSqlQuery(SortColumn sortColumn, SortDirection sortDirection)\n{\n    string columnName = GetColumnName(sortColumn);\n    string direction = sortDirection.ToString();\n    string query = $"SELECT * FROM YourTable ORDER BY {columnName} {direction}";\n    return query;\n}\n\n// Usage example\nSortColumn sortColumn = SortColumn.Column1;\nSortDirection sortDirection = SortDirection.ASC;\nstring query = BuildSqlQuery(sortColumn, sortDirection);\n\n// Execute the query using ADO.NET\nusing (SqlConnection connection = new SqlConnection(connectionString))\n{\n    SqlCommand command = new SqlCommand(query, connection);\n    connection.Open();\n    SqlDataReader reader = command.ExecuteReader();\n    while (reader.Read())\n    {\n        // Process the data\n    }\n    reader.Close();\n}