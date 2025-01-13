using Oracle.ManagedDataAccess.Client;\n\n// Create a connection and command\nOracleConnection conn = new OracleConnection("your_connection_string");\nOracleCommand cmd = new OracleCommand();\ncmd.Connection = conn;\ncmd.CommandText = @"\n    insert into.... ;\n    insert into.... ;\n    delete .........;\n";\n\n// Open the connection and execute the command\nconn.Open();\ncmd.ExecuteNonQuery();\nconn.Close();