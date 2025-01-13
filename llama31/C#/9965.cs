// Use parameterized queries to reduce query overhead\nusing (SqlConnection connection = new SqlConnection(connectionString))\n{\n    connection.Open();\n    SqlCommand command = new SqlCommand("SELECT * FROM users WHERE id = @id", connection);\n    command.Parameters.AddWithValue("@id", id);\n    SqlDataReader reader = command.ExecuteReader();\n}