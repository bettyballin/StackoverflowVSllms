using (OracleConnection conn = new OracleConnection(connectionString))\n   {\n       conn.Open();\n       using (OracleCommand cmd = conn.CreateCommand())\n       {\n           cmd.CommandText = "ALTER SESSION SET NLS_COMP=LINGUISTIC";\n           cmd.ExecuteNonQuery();\n           cmd.CommandText = "ALTER SESSION SET NLS_SORT=BINARY_AI";\n           cmd.ExecuteNonQuery();\n       }\n       // Your database operations go here\n   }