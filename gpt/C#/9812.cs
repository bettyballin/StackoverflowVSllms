internal void RefCursorDataReader()\n{\n    using (OracleConnection con = new OracleConnection(_constr))\n    {\n        using (OracleCommand cmd = new OracleCommand("ABC$MYPACKAGE.MyProc", con))\n        {\n            cmd.CommandType = CommandType.StoredProcedure;\n            cmd.BindByName = true;\n\n            cmd.Parameters.Add("parameter_no1", OracleDbType.Decimal).Value = 12345678;\n            cmd.Parameters.Add("parameter_no2", OracleDbType.Decimal).Value = 123456;\n            cmd.Parameters.Add("RETCURSOR", OracleDbType.RefCursor).Direction = ParameterDirection.Output;\n\n            con.Open();\n\n            using (OracleDataReader reader = cmd.ExecuteReader())\n            {\n                if (reader.Read())\n                {\n                    System.Diagnostics.Debug.WriteLine(reader[0].GetType().ToString());\n                }\n            }\n        }\n    }\n}