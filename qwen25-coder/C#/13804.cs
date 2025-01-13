using System;\nusing System.Data;\nusing System.Data.SqlClient;\n\nclass Program\n{\n    static void Main()\n    {\n        string connectionString = "your_connection_string_here";\n        using (SqlConnection connection = new SqlConnection(connectionString))\n        {\n            SqlCommand cmd = new SqlCommand("MyProcedure", connection);\n            cmd.CommandType = CommandType.StoredProcedure;\n\n            // Add input parameter\n            var param1 = new SqlParameter("@SomeParameter", SqlDbType.Int) { Value = 1 };\n            cmd.Parameters.Add(param1);\n\n            // Add output parameter for affected rows\n            var outParam = new SqlParameter("@AffectedRows", SqlDbType.Int)\n            {\n                Direction = ParameterDirection.Output\n            };\n            cmd.Parameters.Add(outParam);\n\n            connection.Open();\n            cmd.ExecuteNonQuery();\n\n            int affectedRows = (int)cmd.Parameters["@AffectedRows"].Value;\n            Console.WriteLine($"Number of rows affected: {affectedRows}");\n        }\n    }\n}