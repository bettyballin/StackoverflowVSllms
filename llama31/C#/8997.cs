SqlConnection dbEngine = new SqlConnection(connectionString);\nSqlCommand dbCmd = new SqlCommand("InsertDifferential", dbEngine);\nSqlDataAdapter dataAdapter = new SqlDataAdapter(dbCmd);\n\ndbCmd.CommandType = CommandType.StoredProcedure;\n\nif (myobject.differential.HasValue)\n{\n    dbCmd.Parameters.AddWithValue("@differential", myobject.differential);\n}\nelse\n{\n    SqlParameter param = new SqlParameter("@differential", SqlDbType.Int);\n    param.Value = DBNull.Value;\n    param.IsNullable = true;\n    dbCmd.Parameters.Add(param);\n}\n\ndbCmd.ExecuteNonQuery();