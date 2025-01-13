const string QUERY = @"INSERT INTO Questions (Question, Answer, CategoryID, Permission) \n                       OUTPUT INSERTED.ID \n                       VALUES (@Question, @Answer, @CategoryID, @Permission)";\n\nusing (var cmd = new SqlCommand(QUERY, conn))\n{\n    cmd.Parameters.AddWithValue("@Question", question); \n    cmd.Parameters.AddWithValue("@Answer", answer);\n    cmd.Parameters.AddWithValue("@CategoryID", lastEdited);\n    cmd.Parameters.AddWithValue("@Permission", categoryID);\n\n    var lastId = (int)cmd.ExecuteScalar(); // ExecuteScalar since it returns a single value\n    // Use the lastId as needed, for example to join with something else\n}