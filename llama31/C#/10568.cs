const string QUERY = @"INSERT INTO Questions (Question, Answer, CategoryID, Permission) " \n                   + @"VALUES (@Question, @Answer, @CategoryID, @Permission); "\n                   + @"SELECT SCOPE_IDENTITY()";\n\nusing (var cmd = new SqlCommand(QUERY, conn))\n{\n    cmd.Parameters.AddWithValue("@Question", question);\n    cmd.Parameters.AddWithValue("@Answer", answer);\n    cmd.Parameters.AddWithValue("@CategoryID", lastEdited);\n    cmd.Parameters.AddWithValue("@Permission", categoryID);\n    var lastInsertedId = (int)cmd.ExecuteScalar();\n}