public static class SqlQueries\n{\n    public const string GetUsers = @"\n        SELECT id, username, email\n        FROM users\n        WHERE is_active = TRUE\n    ";\n\n    public const string InsertUser = @"\n        INSERT INTO users (username, email, password)\n        VALUES (@Username, @Email, @Password)\n    ";\n\n    public const string UpdateUserEmail = @"\n        UPDATE users\n        SET email = @Email\n        WHERE id = @UserId\n    ";\n}