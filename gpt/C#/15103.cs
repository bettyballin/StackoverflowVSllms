SqlConnection connection = new SqlConnection(connectionString);\nconnection.Open();\n\nSqlCommand command = new SqlCommand(query, connection);\nSqlDataReader reader = command.ExecuteReader();\n\n// Closing the connection before the reader\nconnection.Close();\n\n// The reader is now also closed\nreader.Close(); // This is effectively redundant because the reader is already closed