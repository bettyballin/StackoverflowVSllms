DataSet ds = new DataSet();\nOracleConnection conn = new OracleConnection(this.connStr);\nOracleCommand com = new OracleCommand("MYPKG.MYQUERY", conn);\nOracleDataAdapter adapter = new OracleDataAdapter(com);\nconn.Open();\ncom.Parameters.Add("searchParam", OracleDbType.Varchar2).Value = "myName";\ncom.Parameters.Add("outCursor", OracleDbType.RefCursor, ParameterDirection.Output);\ncom.CommandType = CommandType.StoredProcedure;\n\nadapter.Fill(ds);\n\n// Close the ref cursor explicitly\ncom.Parameters["outCursor"].Value = null;\n\nconn.Close();\nconn.Dispose();\ncom.Dispose();