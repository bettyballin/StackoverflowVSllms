using System;\nusing System.Data.SqlClient;\n\npublic class SqlInjectionPrevention\n{\n    public void ExecuteSecureQuery(string userInput)\n    {\n        string connectionString = "your_connection_string_here"; // Replace with your actual connection string\n\n        using (SqlConnection connection = new SqlConnection(connectionString))\n        {\n            connection.Open();\n\n            string query = "SELECT * FROM Users WHERE Username = @username";\n            using (SqlCommand command = new SqlCommand(query, connection))\n            {\n                // Add the parameter and set its value\n                command.Parameters.Add(new SqlParameter("@username", userInput));\n\n                using (SqlDataReader reader = command.ExecuteReader())\n                {\n                    while (reader.Read())\n                    {\n                        Console.WriteLine(reader["Username"].ToString());\n                    }\n                }\n            }\n        }\n    }\n}