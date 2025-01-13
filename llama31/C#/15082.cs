using System;\nusing System.Data.SqlClient;\nusing System.IO;\n\npublic class ImageStorage\n{\n    public void StoreImage(string connectionString, byte[] imageBytes)\n    {\n        using (SqlConnection connection = new SqlConnection(connectionString))\n        {\n            connection.Open();\n\n            SqlCommand command = new SqlCommand("INSERT INTO Images (Image) VALUES (@Image)", connection);\n            command.Parameters.AddWithValue("@Image", imageBytes);\n\n            command.ExecuteNonQuery();\n        }\n    }\n\n    public byte[] RetrieveImage(string connectionString, int imageId)\n    {\n        using (SqlConnection connection = new SqlConnection(connectionString))\n        {\n            connection.Open();\n\n            SqlCommand command = new SqlCommand("SELECT Image FROM Images WHERE Id = @Id", connection);\n            command.Parameters.AddWithValue("@Id", imageId);\n\n            byte[] imageBytes = (byte[])command.ExecuteScalar();\n\n            return imageBytes;\n        }\n    }\n}