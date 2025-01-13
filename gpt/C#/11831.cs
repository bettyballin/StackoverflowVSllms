public int GetNextValueFromDatabase(string tableName)\n{\n    using (var connection = new SqlConnection("your_connection_string"))\n    {\n        using (var command = new SqlCommand("GetNextValue", connection))\n        {\n            command.CommandType = CommandType.StoredProcedure;\n            command.Parameters.AddWithValue("@TableName", tableName);\n\n            var nextValueParam = new SqlParameter("@NextValue", SqlDbType.Int) { Direction = ParameterDirection.Output };\n            command.Parameters.Add(nextValueParam);\n\n            connection.Open();\n            command.ExecuteNonQuery();\n\n            return (int)nextValueParam.Value;\n        }\n    }\n}