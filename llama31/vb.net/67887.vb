Private Sub Form_BeforeUpdate(Cancel As Integer)\n    If MsgBox("Are you sure you want to save changes?", vbYesNo) = vbNo Then\n        Cancel = True\n    End If\nEnd Sub