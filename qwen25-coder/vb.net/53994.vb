Private Sub ParentForm_FormClosing(sender As Object, e As FormClosingEventArgs) Handles MyBase.FormClosing\n    ' Dispose all child forms when the parent form is closing\n    For Each frmChild As Form In Me.MdiChildren\n        frmChild.Close()\n    Next\nEnd Sub\n\nPrivate Sub ChildForm_FormClosing(sender As Object, e As FormClosingEventArgs) Handles MyBase.FormClosing\n    ' Ensure parent reference is not used after disposal\n    If Not Me.Parent Is Nothing Then\n        ' Perform any final actions before closing\n    End If\nEnd Sub