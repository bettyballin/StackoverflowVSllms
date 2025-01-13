public static void AddSomething(string something)\n{\n    using (SqlConnection connection = new SqlConnection("your-connection-string"))\n    {\n        connection.Open();\n        using (SqlCommand command = new SqlCommand("your-SQL-query", connection))\n        {\n            // Add parameters if needed\n            command.Parameters.AddWithValue("@param", something);\n            \n            // Execute the command\n            command.ExecuteNonQuery();\n        }\n    }\n}