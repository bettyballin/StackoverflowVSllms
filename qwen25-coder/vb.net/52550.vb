Public Sub New(ByVal connectionString As String)\n    _connectionString = connectionString\nEnd Sub\n\nPublic Function FillDataset(ByVal cmd As String, ByVal cmdType As CommandType, Optional ByVal parameters() As SqlParameter = Nothing) As DataSet\n    Using connection As New SqlConnection(_connectionString), _\n          command As New SqlCommand(cmd, connection)\n        command.CommandType = cmdType\n        AssignParameters(command, parameters)\n\n        Dim res As New DataSet()\n        Using sqlda As New SqlDataAdapter(command)\n            sqlda.Fill(res)\n        End Using\n        Return res\n    Catch ex As Exception\n        CreateDataEntry(ex, WriteType.ToFile, cmd)\n        Throw ' Rethrow the exception after logging to propagate it up the call stack if needed.\n    End Try\nEnd Function\n\nPublic Function ExecuteNonQuery(ByVal spname As String, ByVal ParamArray parameterValues() As Object) As Object\n    Using connection As New SqlConnection(_connectionString), _\n          command As New SqlCommand(spname, connection)\n        command.CommandType = CommandType.StoredProcedure\n        command.Parameters.AddRange(parameterValues)\n\n        connection.Open()\n        command.ExecuteNonQuery()\n        Return command.Parameters(command.Parameters.Count - 1).Value\n    Catch ex As Exception\n        CreateDataEntry(ex, WriteType.ToFile, spname)\n        If Not transaction Is Nothing Then\n            transaction.Rollback()\n        End If\n        Throw ' Rethrow the exception after logging to propagate it up the call stack if needed.\n    End Try\nEnd Functio