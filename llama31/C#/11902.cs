private void ExecuteStoredProcedure(string procedureName, SqlParameter[] parameters)\n{\n    using (SqlConnection sql = new SqlConnection(_connString.ConnectionString))\n    using (SqlCommand cmd = sql.CreateCommand())\n    {\n        cmd.CommandText = procedureName;\n        cmd.CommandType = CommandType.StoredProcedure;\n        cmd.Parameters.AddRange(parameters);\n\n        sql.Open();\n        cmd.ExecuteNonQuery();\n    }\n}