using (SQLiteConnection conn = new SQLiteConnection("Data Source=your_database.db"))\n{\n    conn.Open();\n    using (SQLiteTransaction transaction = conn.BeginTransaction())\n    {\n        using (SQLiteCommand cmd = conn.CreateCommand())\n        {\n            cmd.CommandText = "INSERT INTO Prototype (ParentID) VALUES (NULL);";\n            cmd.ExecuteNonQuery();\n            \n            cmd.CommandText = "SELECT last_insert_rowid();";\n            long lastInsertedId = (long)cmd.ExecuteScalar();\n            \n            // Use lastInsertedId as needed\n        }\n        transaction.Commit();\n    }\n}