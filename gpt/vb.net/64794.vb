Dim oracleConnection As New OracleConnection()\noracleConnection.ConnectionString = LocalConnectionString()\n\nDim cmd As New OracleCommand()\ncmd.Connection = oracleConnection\ncmd.CommandText = "SELECT FALCON.CMS_DATA.GET_MAX_CMS_TH(:i_FACID_C) FROM DUAL"\ncmd.CommandType = CommandType.Text\n\ncmd.Parameters.Add(New OracleParameter("i_FACID_C", OracleType.Char)).Value = facilityShortName\n\nTry\n    oracleConnection.Open()\n    Dim result As Object = cmd.ExecuteScalar()\n    If result IsNot Nothing Then\n        Return CDate(result)\n    Else\n        Throw New Exception("No data returned.")\n    End If\nCatch ex As Exception\n    ' Handle exceptions\n    Throw ex\nFinally\n    oracleConnection.Close()\nEnd Try