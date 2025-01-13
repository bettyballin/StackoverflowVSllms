using (SqlConnection connection = new SqlConnection(connectionString))\n{\n    connection.Open();\n    SqlCommand command = new SqlCommand("SELECT * FROM myTable WHERE myStuff = @myStuff", connection);\n    command.Parameters.AddWithValue("@myStuff", "StackOverflow");\n    SqlDataReader reader = command.ExecuteReader();\n    // ...\n}