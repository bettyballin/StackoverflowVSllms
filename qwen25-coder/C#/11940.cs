using System.Data;\nusing System.Data.SqlClient;\n\npublic class DatabaseInfoChecker\n{\n    public static string GetDbVersion(string connectionString)\n    {\n        using (var connection = new SqlConnection(connectionString))\n        {\n            try\n            {\n                connection.Open();\n                var command = new SqlCommand("SELECT @@VERSION", connection);\n                return command.ExecuteScalar()?.ToString() ?? string.Empty;\n            }\n            catch (Exception ex)\n            {\n                // Handle exceptions as appropriate, e.g., log the error and rethrow.\n                throw;\n            }\n        }\n    }\n\n    public static bool IsSqlExpress(string versionString)\n    {\n        if (string.IsNullOrEmpty(versionString)) return false;\n\n        return versionString.IndexOf("SQL Server Express", StringComparison.OrdinalIgnoreCase) >= 0;\n    }\n}