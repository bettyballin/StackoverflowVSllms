Protected Sub GridView1_RowCommand(ByVal sender As Object, ByVal e As GridViewCommandEventArgs) Handles GridView1.RowCommand\n    If e.CommandName = "YourCommandName" Then\n        ' Find the row that contains the button clicked.\n        Dim button As Button = CType(sender, Button)\n        Dim row As GridViewRow = CType(button.NamingContainer, GridViewRow)\n\n        ' Get the index of the selected row.\n        Dim rowIndex As Integer = row.RowIndex\n\n        ' Do something with rowIndex...\n    End If\nEnd Sub