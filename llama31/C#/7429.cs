using System.Data.SqlClient;\n\n// Connection string with SQL authentication\nstring connectionString = "Data Source=myServerAddress;Initial Catalog=myDataBase;User Id=myUsername;Password=myPassword;";\n\n// Create a new SqlConnection object\nusing (SqlConnection connection = new SqlConnection(connectionString))\n{\n    // Open the connection\n    connection.Open();\n\n    // Execute queries or stored procedures\n    // ...\n}