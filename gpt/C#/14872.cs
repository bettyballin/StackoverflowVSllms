using System;\nusing System.Data.SqlClient;\n\nclass Program\n{\n    static void Main()\n    {\n        string connectionString = "your_connection_string_here";\n\n        using (SqlConnection conn = new SqlConnection(connectionString))\n        {\n            conn.Open();\n            SqlCommand cmd = conn.CreateCommand();\n            // Your SQL operations\n            cmd.ExecuteReader(CommandBehavior.CloseConnection);\n        }\n\n        // Clear the connection pool to forcefully close the connection\n        SqlConnection.ClearAllPools();\n    }\n}