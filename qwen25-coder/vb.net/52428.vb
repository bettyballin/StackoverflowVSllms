Private Sub RadioButton_CheckedChanged(ByVal sender As System.Object, _\n       ByVal e As System.EventArgs) Handles RadioButton1.CheckedChanged\n\n    ' Cast the sender back to a RadioButton since it could be any control.\n    Dim radioButton As RadioButton = CType(sender, RadioButton)\n\n    If radioButton.Checked Then \n        Beep()\n    End If\nEnd Sub