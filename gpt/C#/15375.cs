using System;\nusing System.IO;\nusing System.IO.Compression;\nusing System.Data.SqlClient;\n\npublic class EmailCompressor\n{\n    public static byte[] CompressString(string text)\n    {\n        byte[] buffer = System.Text.Encoding.UTF8.GetBytes(text);\n        using (MemoryStream memoryStream = new MemoryStream())\n        {\n            using (GZipStream gZipStream = new GZipStream(memoryStream, CompressionMode.Compress, true))\n            {\n                gZipStream.Write(buffer, 0, buffer.Length);\n            }\n            return memoryStream.ToArray();\n        }\n    }\n\n    public static string DecompressString(byte[] compressedText)\n    {\n        using (MemoryStream memoryStream = new MemoryStream(compressedText))\n        {\n            using (GZipStream gZipStream = new GZipStream(memoryStream, CompressionMode.Decompress))\n            {\n                using (StreamReader reader = new StreamReader(gZipStream, System.Text.Encoding.UTF8))\n                {\n                    return reader.ReadToEnd();\n                }\n            }\n        }\n    }\n\n    public static void StoreCompressedEmailBody(string emailBody, string connectionString)\n    {\n        byte[] compressedBody = CompressString(emailBody);\n\n        using (SqlConnection connection = new SqlConnection(connectionString))\n        {\n            connection.Open();\n            string query = "INSERT INTO Emails (CompressedBody) VALUES (@CompressedBody)";\n            using (SqlCommand command = new SqlCommand(query, connection))\n            {\n                command.Parameters.AddWithValue("@CompressedBody", compressedBody);\n                command.ExecuteNonQuery();\n            }\n        }\n    }\n\n    public static string RetrieveCompressedEmailBody(int emailId, string connectionString)\n    {\n        byte[] compressedBody;\n\n        using (SqlConnection connection = new SqlConnection(connectionString))\n        {\n            connection.Open();\n            string query = "SELECT CompressedBody FROM Emails WHERE EmailId = @EmailId";\n            using (SqlCommand command = new SqlCommand(query, connection))\n            {\n                command.Parameters.AddWithValue("@EmailId", emailId);\n                compressedBody = (byte[])command.ExecuteScalar();\n            }\n        }\n\n        return DecompressString(compressedBody);\n    }\n}