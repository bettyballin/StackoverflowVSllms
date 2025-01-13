using MySql.Data.MySqlClient;\n\nclass Program\n{\n    static void Main(string[] args)\n    {\n        // Connection string\n        string connectionString = "Server=localhost;Database=mydatabase;User ID=myuser;Password=mypassword;";\n\n        // Create a MySQL connection\n        using (MySqlConnection connection = new MySqlConnection(connectionString))\n        {\n            connection.Open();\n\n            // Create a command\n            MySqlCommand command = new MySqlCommand("SELECT * FROM mytable", connection);\n\n            // Execute the command and read the results\n            MySqlDataReader reader = command.ExecuteReader();\n\n            while (reader.Read())\n            {\n                Console.WriteLine(reader["column1"].ToString() + " " + reader["column2"].ToString());\n            }\n\n            reader.Close();\n        }\n\n        Console.ReadKey();\n    }\n}