public IEnumerable<YourDataType> GetItems(int pageSize, int pageNumber)\n{\n    const int defaultPageSize = 20; // Default number of items per page\n    using (var connection = new SqlConnection(connectionString))\n    {\n        connection.Open();\n        string query = "SELECT * FROM YourTable "\n                     + "ORDER BY SomeColumn " // Important to order your results!\n                     + "OFFSET @Skip ROWS FETCH NEXT @Take ROWS ONLY";\n        using (var command = new SqlCommand(query, connection))\n        {\n            command.Parameters.Add("@Skip", SqlDbType.Int).Value = (pageNumber - 1) * pageSize;\n            command.Parameters.Add("@Take", SqlDbType.Int).Value = pageSize;\n\n            SqlDataReader reader = command.ExecuteReader();\n            while (reader.Read())\n            {\n                yield return ConvertToYourDataType(reader);\n            }\n        }\n    }\n}\n\nprivate YourDataType ConvertToYourDataType(SqlDataReader reader)\n{\n    // Map fields from the data reader to your data type\n    var item = new YourDataType();\n    item.SomeField = reader["SomeField"].ToString(); // Example mapping\n    return item;\n}