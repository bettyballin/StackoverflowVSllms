using System.Data.SQLite;\nusing System.Linq;\n\n// Create a connection\nSQLiteConnection conn = new SQLiteConnection("Data Source=:memory:");\n\n// Create a table\nconn.Execute("CREATE TABLE Users (Id INTEGER PRIMARY KEY, Name TEXT)");\n\n// Insert data\nconn.Execute("INSERT INTO Users (Name) VALUES ('John Doe')");\n\n// Query data\nvar users = conn.Table<User>().Where(u => u.Name == "John Doe");