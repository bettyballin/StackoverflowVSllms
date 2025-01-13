private string BuildOrderByClause(string[] columns, bool ascending)\n{\n    HashSet<string> allowedColumns = new HashSet<string> { "column1", "column2", "column3" };\n    List<string> safeColumns = new List<string>();\n\n    foreach (var column in columns)\n    {\n        if (allowedColumns.Contains(column))\n        {\n            safeColumns.Add(column);\n        }\n    }\n\n    string orderDirection = ascending ? "ASC" : "DESC";\n    return string.Join(", ", safeColumns) + " " + orderDirection;\n}\n\nprivate void GetOrderedData(string[] orderByColumns, bool ascending)\n{\n    string orderByClause = BuildOrderByClause(orderByColumns, ascending);\n    string sqlQuery = "SELECT * FROM your_table ORDER BY " + orderByClause;\n\n    using (var connection = new SqlConnection("your_connection_string"))\n    {\n        using (var command = new SqlCommand(sqlQuery, connection))\n        {\n            // Execute the query\n            connection.Open();\n            var reader = command.ExecuteReader();\n            // Process data...\n        }\n    }\n}