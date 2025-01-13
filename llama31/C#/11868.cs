using System.Data.SqlClient;\n\nclass Program\n{\n    static void Main()\n    {\n        string connectionString = "Data Source=<server_name>;Initial Catalog=<database_name>;User ID=<username>;Password=<password>";\n        string query = "SELECT * FROM <table_name>";\n\n        using (SqlConnection connection = new SqlConnection(connectionString))\n        {\n            connection.Open();\n            SqlCommand command = new SqlCommand(query, connection);\n            SqlDataReader reader = command.ExecuteReader();\n\n            while (reader.Read())\n            {\n                Console.WriteLine(reader[0].ToString());\n            }\n        }\n    }\n}