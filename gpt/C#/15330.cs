using (SqlConnection connection = new SqlConnection(connectionString))\n   {\n       string query = "SELECT * FROM Users WHERE Username = @Username";\n       SqlCommand command = new SqlCommand(query, connection);\n       command.Parameters.AddWithValue("@Username", username);\n       connection.Open();\n       SqlDataReader reader = command.ExecuteReader();\n       // Process the results\n   }