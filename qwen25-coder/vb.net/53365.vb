Dim returnedString As String = GetReturnedString()\n   \n   If returnedString.Equals(My.Resources.Errors.UnknownError) Then\n       ' Handle unknown error scenario\n   ElseIf returnedString.Equals(My.Resources.Errors.KnownNotFoundError) Then\n       ' Handle known not found error scenario\n   End If