using System;\nusing System.Data.SQLite;\n\nclass Program\n{\n    static void Main()\n    {\n        string connectionString = "Data Source=sample.db;Version=3;";\n        \n        using (var connection = new SQLiteConnection(connectionString))\n        {\n            connection.Open();\n\n            string createTableQuery = "CREATE TABLE IF NOT EXISTS users (id INTEGER PRIMARY KEY, name TEXT)";\n            using (var command = new SQLiteCommand(createTableQuery, connection))\n            {\n                command.ExecuteNonQuery();\n            }\n\n            string insertQuery = "INSERT INTO users (name) VALUES ('John Doe')";\n            using (var command = new SQLiteCommand(insertQuery, connection))\n            {\n                command.ExecuteNonQuery();\n            }\n\n            string selectQuery = "SELECT * FROM users";\n            using (var command = new SQLiteCommand(selectQuery, connection))\n            using (var reader = command.ExecuteReader())\n            {\n                while (reader.Read())\n                {\n                    Console.WriteLine($"ID: {reader["id"]}, Name: {reader["name"]}");\n                }\n            }\n        }\n    }\n}