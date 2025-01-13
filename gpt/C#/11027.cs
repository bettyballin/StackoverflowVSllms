using System;\nusing System.Data.SqlClient;\nusing System.IO;\n\npublic class BlobHandler\n{\n    private string connectionString = "your_connection_string_here";\n\n    public void WriteBlob(int documentId, Stream data)\n    {\n        using (SqlConnection connection = new SqlConnection(connectionString))\n        {\n            connection.Open();\n            using (SqlCommand command = new SqlCommand("UPDATE Documents SET Body = @Body WHERE DocumentId = @DocumentId", connection))\n            {\n                command.Parameters.Add(new SqlParameter("@DocumentId", documentId));\n                command.Parameters.Add(new SqlParameter("@Body", System.Data.SqlDbType.NVarChar, -1) { Value = data });\n\n                command.ExecuteNonQuery();\n            }\n        }\n    }\n\n    public Stream ReadBlob(int documentId)\n    {\n        using (SqlConnection connection = new SqlConnection(connectionString))\n        {\n            connection.Open();\n            using (SqlCommand command = new SqlCommand("SELECT Body FROM Documents WHERE DocumentId = @DocumentId", connection))\n            {\n                command.Parameters.Add(new SqlParameter("@DocumentId", documentId));\n\n                using (SqlDataReader reader = command.ExecuteReader(System.Data.CommandBehavior.SequentialAccess))\n                {\n                    if (reader.Read())\n                    {\n                        return reader.GetStream(0);\n                    }\n                }\n            }\n        }\n\n        return null;\n    }\n}