SqlConnection conn = new SqlConnection(CONNECTION_STRING);\nSqlCommand cmd = new SqlCommand("sp_mult_tables", conn);\ncmd.CommandType = CommandType.StoredProcedure;\n\nSqlDataAdapter adapter = new SqlDataAdapter(cmd);\nDataSet ds = new DataSet();\n\nadapter.Fill(ds);