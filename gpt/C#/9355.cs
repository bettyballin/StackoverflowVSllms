// Example of parameterized query\nusing (SqlCommand cmd = new SqlCommand("SELECT * FROM Users WHERE UserID = @UserID", connection))\n{\n    cmd.Parameters.AddWithValue("@UserID", userId);\n    // Execute command\n}