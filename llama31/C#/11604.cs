string[] sqlStatements = new string[] {\n    "insert into....",\n    "insert into....",\n    "delete ........."\n};\n\nOracleCommand cmd = new OracleCommand();\ncmd.Connection = conn;\n\nforeach (string statement in sqlStatements)\n{\n    cmd.CommandText = statement;\n    cmd.ExecuteNonQuery();\n}