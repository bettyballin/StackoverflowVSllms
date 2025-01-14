Public Structure Result\n    Public Success As Boolean\n    Public Message As String\nEnd Structure\n\nPrivate _Repository As IEntityRepository\n\nPublic Function SaveOrganization(ByVal organization As rv_o_Organization) As Result\n    Dim result = New Result With {.Success = False}\n\n    Try\n        _Repository.Connection.Open()\n        _Repository.Transaction = _Repository.Connection.BeginTransaction()\n\n        ' Performs validation then saves it to the database using the current transaction\n        result = SaveMasterOrganization(organization.MasterOrganization)\n        If (Not result.Success) Then Throw New Exception(result.Message)\n\n        ' Performs validation then saves it to the database using the current transaction\n        result = SaveOrganziation(dbOrg, organization)\n        If (Not result.Success) Then Throw New Exception(result.Message)\n\n        _Repository.Transaction.Commit()\n    Catch ex As Exception\n        result.Success = False\n        result.Message = ex.Message\n        _Repository.Transaction.Rollback()\n    Finally\n        ' Ensure the connection is closed even if an error occurs.\n        If (_Repository.Connection IsNot Nothing AndAlso _Repository.Connection.State <> ConnectionState.Closed) Then\n            _Repository.Connection.Close()\n        End If\n    End Try\n\n    Return result\nEnd Functio