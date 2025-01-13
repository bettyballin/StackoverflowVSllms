using (SqlConnection connection = new SqlConnection(connectionString))\n{\n    connection.Open();\n\n    // Get the query's session ID\n    SqlCommand command = new SqlCommand("SELECT @@SPID", connection);\n    int sessionId = (int)command.ExecuteScalar();\n\n    // Execute your query here\n    SqlCommand queryCommand = new SqlCommand("SELECT * FROM large_table", connection);\n    queryCommand.ExecuteNonQuery();\n\n    // Poll the sys.dm_exec_query_stats DMV\n    while (true)\n    {\n        SqlCommand statsCommand = new SqlCommand("SELECT cpu_time, elapsed_time FROM sys.dm_exec_query_stats WHERE session_id = @sessionId", connection);\n        statsCommand.Parameters.AddWithValue("@sessionId", sessionId);\n\n        SqlDataReader reader = statsCommand.ExecuteReader();\n        while (reader.Read())\n        {\n            // Get the elapsed time and CPU usage\n            int cpuTime = reader.GetInt32(0);\n            int elapsedTime = reader.GetInt32(1);\n            // Update your progress bar here\n        }\n\n        // Wait for a short period before polling again\n        Thread.Sleep(100);\n    }\n}