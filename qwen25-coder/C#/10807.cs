using System;\nusing System.Data.SqlClient;\nusing System.IO;\n\nclass Program\n{\n    static void Main()\n    {\n        string connectionString = "your_connection_string_here";\n        using (SqlConnection connection = new SqlConnection(connectionString))\n        {\n            string query = "SELECT ImageColumnName, FileName FROM YourTableName";\n            SqlCommand command = new SqlCommand(query, connection);\n            connection.Open();\n            \n            SqlDataReader reader = command.ExecuteReader();\n\n            while (reader.Read())\n            {\n                byte[] imageBytes = (byte[])reader["ImageColumnName"];\n                string fileName = reader["FileName"].ToString();\n                \n                // Assuming you want to save the images in a specific directory\n                string pathToSave = @"C:\Images\" + fileName;\n                File.WriteAllBytes(pathToSave, imageBytes);\n            }\n        }\n    }\n}