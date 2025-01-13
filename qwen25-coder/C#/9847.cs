using System.Data.SqlClient;\n\n// Create a new SqlConnection object\nSqlConnection connection = new SqlConnection("your_connection_string_here");\n\n// Set the CommandTimeout property (in seconds)\nconnection.CommandTimeout = 30; // Example: waits for up to 30 seconds\n\ntry\n{\n    connection.Open();\n    // Execute your command here\n}\ncatch (Exception ex)\n{\n    Console.WriteLine(ex.Message);\n}\nfinally\n{\n    connection.Close();\n}