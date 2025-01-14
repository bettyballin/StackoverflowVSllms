<%\nFunction GetSessionData(sessionID)\n    Dim rs, cmdGet\n    Set rs = Server.CreateObject("ADODB.Recordset")\n    Set cmdGet = Server.CreateObject("ADODB.Command")\n    cmdGet.ActiveConnection = connStr\n\n    cmdGet.CommandText = "SELECT * FROM SessionData WHERE SessionID = '" & Server.HTMLEncode(sessionID) & "'"\n    rs.Open cmdGet, , adOpenStatic, adLockOptimistic\n    If Not rs.EOF Then\n        GetSessionData = rs("FirstName")\n        ' Retrieve other necessary fields here\n    Else\n        GetSessionData = "No data found for this session."\n    End If\n    rs.Close\n    Set rs = Nothing\nEnd Function\n\n' Example usage: Assume remoteServiceSessionID is the SessionID received from remote service\nDim userInfo\nuserInfo = GetSessionData(remoteServiceSessionID)\nResponse.Write "User's First Name: " & userInfo\n%>