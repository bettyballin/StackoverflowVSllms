Protected Sub GridView_RowCommand(sender As Object, e As GridViewCommandEventArgs)\n    If e.CommandName = "YourCommandName" Then\n        ' Get the row index stored in the CommandArgument property.\n        Dim rowIndex As Integer = Convert.ToInt32(e.CommandArgument)\n        ' Retrieve the row using the row index.\n        Dim row As GridViewRow = GridView.Rows(rowIndex)\n        \n        ' You can now work with the row, for example:\n        ' Dim cellValue As String = row.Cells(0).Text\n    End If\nEnd Sub