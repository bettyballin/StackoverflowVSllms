Dim dr As DbDataReader = Nothing\nTry\n    dr = connection.GetDataReader(sql_str)\nCatch ex As SqlClientException\n    log.Error(ex)\nFinally\n    If dr IsNot Nothing Then\n        dr.Close()\n    End If\nEnd Try