string connectionString = "server=***;database=***;user id=***;pwd=***";\nusing (SqlConnection connection = new SqlConnection(connectionString))\n{\n    connection.Open();\n    \n    // Set ARITHABORT ON\n    using (SqlCommand setArithAbortCommand = new SqlCommand("SET ARITHABORT ON", connection))\n    {\n        setArithAbortCommand.ExecuteNonQuery();\n    }\n\n    string selectCommand = @"EXEC sp_Stat @DepartmentID = NULL";\n    using (SqlCommand command = new SqlCommand(selectCommand, connection))\n    {\n        using (SqlDataReader reader = command.ExecuteReader())\n        {\n            while (reader.Read())\n            {\n                // Process your data here\n            }\n        }\n    }\n}