cmd = new SqlCommand("StoredProc");\ncmd.CommandType = CommandType.StoredProcedure;\ncmd.Parameters.Add("@p1", 1);\ncmd.Parameters.Add("@p2", 2);