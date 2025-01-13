using Oracle.DataAccess.Client;\nusing System.Data;\n\n// Create a connection to the Oracle database\nOracleConnection conn = new OracleConnection("Data Source=your_database;User ID=your_username;Password=your_password;");\n\n// Create a command to execute the procedure\nOracleCommand cmd = new OracleCommand("GETSOMEDATA", conn);\ncmd.CommandType = CommandType.StoredProcedure;\n\n// Add the SYS_REFCURSOR output parameter\nOracleParameter param = new OracleParameter("P_Data", OracleDbType.RefCursor, ParameterDirection.Output);\ncmd.Parameters.Add(param);\n\n// Open the connection and execute the procedure\nconn.Open();\ncmd.ExecuteNonQuery();\n\n// Get the SYS_REFCURSOR output parameter value\nOracleRefCursor cursor = (OracleRefCursor)cmd.Parameters["P_Data"].Value;\n\n// Create a data adapter to fill a DataTable with the cursor's data\nOracleDataAdapter adapter = new OracleDataAdapter(cmd);\nDataTable dt = new DataTable();\nadapter.Fill(dt, cursor);\n\n// Bind the DataTable to the GridView\ngrdData.DataSource = dt;\ngrdData.DataBind();\n\n// Clean up\nconn.Close();\ncmd.Dispose();