cmd = new SqlCommand("StoredProc");\ncmd.CommandType = CommandType.StoredProcedure;\ncmd.Parameters.AddWithValue("@p1", 1);\ncmd.Parameters.AddWithValue("@p2", 2);