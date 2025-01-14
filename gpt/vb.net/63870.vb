Dim conn, cmd, param\n\n   ' Create a connection object\n   Set conn = Server.CreateObject("ADODB.Connection")\n   conn.Open "your_connection_string"\n\n   ' Create a command object\n   Set cmd = Server.CreateObject("ADODB.Command")\n   cmd.ActiveConnection = conn\n   cmd.CommandText = "SELECT * FROM Users WHERE Username = ?"\n   cmd.CommandType = adCmdText\n\n   ' Create a parameter object and append it to the command\n   Set param = cmd.CreateParameter("@Username", adVarChar, adParamInput, 255, Request("username"))\n   cmd.Parameters.Append param\n\n   ' Execute the query\n   Set rs = cmd.Execute\n\n   ' Process the results\n   If Not rs.EOF Then\n       ' Do something with the results\n   End If\n\n   ' Clean up\n   rs.Close\n   Set rs = Nothing\n   Set cmd = Nothing\n   conn.Close\n   Set conn = Nothing