using System;\nusing System.Data.SqlClient;\n\npublic class SqlServerMessagesExample\n{\n    public void ExecuteNonQueryAndCaptureMessages()\n    {\n        string connectionString = "your_connection_string_here";\n        using (SqlConnection connection = new SqlConnection(connectionString))\n        {\n            // Subscribe to the InfoMessage event.\n            connection.InfoMessage += OnInfoMessage;\n            \n            try\n            {\n                connection.Open();\n                \n                // Create and execute a SqlCommand\n                string sql = "RESTORE DATABASE testdb FROM DISK = 'C:\\backups\\testdb.bak'";\n                using (SqlCommand command = new SqlCommand(sql, connection))\n                {\n                    command.ExecuteNonQuery();\n                }\n            }\n            catch (SqlException ex)\n            {\n                Console.WriteLine("An error occurred: " + ex.Message);\n            }\n        }\n    }\n\n    // Event handler for the InfoMessage event\n    private void OnInfoMessage(object sender, SqlInfoMessageEventArgs e)\n    {\n        foreach (SqlError err in e.Errors)\n        {\n            Console.WriteLine(err.Message);\n        }\n    }\n}