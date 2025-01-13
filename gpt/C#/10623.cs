public void AddComment(int postId, string content)\n{\n    using (var connection = new SqlConnection(connectionString))\n    {\n        connection.Open();\n        using (var transaction = connection.BeginTransaction())\n        {\n            var addCommentCommand = new SqlCommand("INSERT INTO Comments (PostID, Content) VALUES (@PostID, @Content)", connection, transaction);\n            addCommentCommand.Parameters.AddWithValue("@PostID", postId);\n            addCommentCommand.Parameters.AddWithValue("@Content", content);\n            addCommentCommand.ExecuteNonQuery();\n\n            var updateCountCommand = new SqlCommand("UPDATE Posts SET CommentCount = CommentCount + 1 WHERE PostID = @PostID", connection, transaction);\n            updateCountCommand.Parameters.AddWithValue("@PostID", postId);\n            updateCountCommand.ExecuteNonQuery();\n\n            transaction.Commit();\n        }\n    }\n}