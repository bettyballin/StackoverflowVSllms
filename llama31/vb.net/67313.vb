Dim email As String = "foo@bar.com"\nDim atIndex As Integer = email.IndexOf("@")\nIf atIndex <> -1 Then\n    Dim domain As String = email.Substring(atIndex)\n    ' domain will now hold "@bar.com"\nEnd If