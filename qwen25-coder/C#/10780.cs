void LogUserActivity(string userId, string action)\n{\n    // Example function to log activity\n    using (SqlConnection conn = new SqlConnection(connectionString))\n    {\n        SqlCommand cmd = new SqlCommand("Insert into UserLog(UserID, Action) Values(@UserID, @Action)", conn);\n        cmd.Parameters.AddWithValue("@UserID", userId);\n        cmd.Parameters.AddWithValue("@Action", action);\n        conn.Open();\n        cmd.ExecuteNonQuery();\n    }\n}