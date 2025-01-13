public void getDocument(int documentID, out int clientID, out string documentName)\n    {\n        using (SqlConnection connection = new SqlConnection(connectionString))\n        {\n            connection.Open();\n            using (SqlCommand command = new SqlCommand("select ClientID, DocumentName from Document where DocumentID = @DocumentID", connection))\n            {\n                command.Parameters.AddWithValue("@DocumentID", documentID);\n                using (SqlDataReader reader = command.ExecuteReader())\n                {\n                    if (reader.Read())\n                    {\n                        clientID = reader.GetInt32(0);\n                        documentName = reader.GetString(1);\n                    }\n                    else\n                    {\n                        clientID = 0;\n                        documentName = string.Empty;\n                    }\n                }\n            }\n        }\n    }