using (SqlConnection connection = new SqlConnection(connectionString))\n{\n    connection.Open();\n    // Perform database operations\n}\n// Connection is automatically closed and disposed of when exiting the using block