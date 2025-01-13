' Assume you have already established a connection to your database\nDim conn, rs, newID\n\nSet conn = Server.CreateObject("ADODB.Connection")\nconn.Open "your_connection_string"\n\n' Insert a new record\nconn.Execute "INSERT INTO your_table (column1, column2) VALUES ('value1', 'value2')"\n\n' Get the autogenerated ID\nSet rs = conn.Execute("SELECT SCOPE_IDENTITY() AS newID")\nnewID = rs("newID")\n\n' Clean up\nrs.Close\nSet rs = Nothing\nconn.Close\nSet conn = Nothing