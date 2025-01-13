private bool IsUserSessionActive(int userId)\n{\n    using (var connection = new SqlConnection(ConnectionString))\n    {\n        const string query = "SELECT COUNT(*) FROM UserSessions WHERE UserId=@userId";\n        connection.Open();\n        using (var command = new SqlCommand(query, connection))\n        {\n            command.Parameters.AddWithValue("@userId", userId);\n            return (int)command.ExecuteScalar() > 0;\n        }\n    }\n}\n\n// During login\nprotected void SignInUser(User user)\n{\n    if (IsUserSessionActive(user.Id))\n    {\n        // Handle the case where another session is active, e.g., log error, show message.\n        throw new InvalidOperationException("Another session is already active for this account.");\n    }\n\n    // If no session is active, proceed with authentication\n    FormsAuthentication.SetAuthCookie(user.UserName, false);\n}