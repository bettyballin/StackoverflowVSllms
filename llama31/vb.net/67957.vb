Private Sub Form_BeforeUpdate(Cancel As Integer)\n    On Error GoTo ErrorHandler\n    \n    ' Validate field 1\n    If Me.Field1.Value = "" Then\n        Err.Raise 1000, "Field 1 is required"\n    End If\n    \n    ' Validate field 2\n    If Me.Field2.Value < 0 Then\n        Err.Raise 1001, "Field 2 must be greater than 0"\n    End If\n    \n    Exit Sub\n    \nErrorHandler:\n    ' Handle the error programmatically\n    ' For example, log the error or send an email to the administrator\n    MsgBox "Error " & Err.Number & ": " & Err.Description, vbCritical\n    Cancel = True\nEnd Sub