Dim cmd\nSet cmd = Server.CreateObject("ADODB.Command")\ncmd.ActiveConnection = dbConn\ncmd.CommandText = "SELECT * FROM Users WHERE active = 1 AND username=? AND password=?"\ncmd.CommandType = 1 ' adCmdText\ncmd.Parameters.Append cmd.CreateParameter("@username", 200, 1, 50, Request.Form("username")) ' 200 - adVarChar, 1 - adParamInput\ncmd.Parameters.Append cmd.CreateParameter("@password", 200, 1, 50, Request.Form("password")) ' Assuming username and password are strings\nDim RS\nSet RS = cmd.Execute()