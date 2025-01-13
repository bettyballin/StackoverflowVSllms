using (SqlConnection connection = new SqlConnection(connectionString))\n{\n    connection.Open();\n\n    SqlCommand command = new SqlCommand("your_stored_procedure_name", connection);\n    command.CommandType = CommandType.StoredProcedure;\n\n    object result = command.ExecuteScalar();\n\n    if (result != null)\n    {\n        int count = Convert.ToInt32(result);\n        // use the count value as needed\n    }\n}