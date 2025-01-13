private static long GetNextEventId(DbConnection dbConnection)\n{\n    using (DbCommand cmd = dbConnection.CreateCommand())\n    {\n        cmd.CommandText = "LogEntities.GetNextEventId";\n        cmd.CommandType = CommandType.StoredProcedure;\n\n        // Execute the command\n        return Convert.ToInt64(cmd.ExecuteScalar());\n    }\n}