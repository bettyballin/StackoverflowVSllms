using System;\nusing System.Data;\nusing System.Data.SqlClient;\n\npublic void GetTags(DataTable tagNames)\n{\n    string connectionString = "your_connection_string_here";\n    using (SqlConnection connection = new SqlConnection(connectionString))\n    {\n        using (SqlCommand command = new SqlCommand("dbo.GetTags", connection))\n        {\n            command.CommandType = CommandType.StoredProcedure;\n\n            SqlParameter parameter = new SqlParameter();\n            parameter.ParameterName = "@TagNames";\n            parameter.SqlDbType = SqlDbType.Structured;\n            parameter.TypeName = "dbo.TagTableType";\n            parameter.Value = tagNames;\n\n            command.Parameters.Add(parameter);\n\n            connection.Open();\n\n            using (SqlDataReader reader = command.ExecuteReader())\n            {\n                while (reader.Read())\n                {\n                    // Process the results\n                }\n            }\n        }\n    }\n}