Public Function ExecuteNonQuery(ByVal spname As String, ByVal ParamArray parameterValues() As Object) As Object\n    Dim connection As SqlConnection = Nothing\n    Dim command As SqlCommand = Nothing\n    Dim res As Object = Nothing\n    Try\n        connection = New SqlConnection(_connectionString)\n        command = New SqlCommand(spname, connection)\n        command.CommandType = CommandType.StoredProcedure\n\n        For Each paramValue As Object In parameterValues\n            Dim param As SqlParameter = command.CreateParameter()\n            param.ParameterName = "@param" & command.Parameters.Count.ToString()\n            param.Value = paramValue\n            command.Parameters.Add(param)\n        Next\n\n        connection.Open()\n        command.ExecuteNonQuery()\n        res = command.Parameters(command.Parameters.Count - 1).Value\n    Catch ex As Exception\n        CreateDataEntry(ex, WriteType.ToFile, spname)\n        If Not (transaction Is Nothing) Then\n            transaction.Rollback()\n        End If\n    Finally\n        If Not (connection Is Nothing) AndAlso (connection.State = ConnectionState.Open) Then connection.Close()\n        If Not (command Is Nothing) Then command.Dispose()\n    End Try\n    Return res\nEnd Functio