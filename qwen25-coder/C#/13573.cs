using (SqlConnection connection = new SqlConnection(connectionString))\n{\n    SqlCommand command = new SqlCommand("SELECT * FROM Users WHERE Id = @userId", connection);\n    command.Parameters.AddWithValue("@userId", userId);\n\n    connection.Open();\n    SqlDataReader reader = command.ExecuteReader();\n    // Process data...\n}