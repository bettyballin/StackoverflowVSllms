using System;\nusing System.Data.SqlClient;\n\nclass Program\n{\n    static void Main()\n    {\n        string connectionString = "Server=myServerAddress;Database=myDataBase;User Id=myUsername;Password=myPassword;";\n        string sql = "CREATE VIEW MyView AS SELECT * FROM MyTable";\n\n        using (SqlConnection connection = new SqlConnection(connectionString))\n        {\n            connection.Open();\n\n            using (SqlCommand command = new SqlCommand(sql, connection))\n            {\n                try\n                {\n                    command.ExecuteNonQuery();\n                    Console.WriteLine("View created successfully.");\n                }\n                catch (SqlException ex)\n                {\n                    Console.WriteLine("Failed to create view: " + ex.Message);\n                }\n            }\n        }\n    }\n}