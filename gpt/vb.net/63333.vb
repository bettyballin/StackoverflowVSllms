command.CommandText = "INSERT INTO auhinode (node_key, node_desc) VALUES (0, 'New Node'); SELECT DBINFO('sqlca.sqlerrd1') FROM systables WHERE tabid = 1"\n  \n  Dim newId As Integer\n  Using reader As OdbcDataReader = command.ExecuteReader()\n      If reader.Read() Then\n          newId = Convert.ToInt32(reader(0))\n      End If\n  End Using\n\n  Console.WriteLine("Newly inserted row ID: " & newId)