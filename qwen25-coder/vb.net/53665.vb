Protected Sub GridView1_RowCommand(sender As Object, e As GridViewCommandEventArgs) Handles GridView1.RowCommand\n    If e.CommandName = "DeleteRecord" Then\n        ' Retrieve the row index stored in the CommandArgument property.\n        Dim index As Integer = Convert.ToInt32(e.CommandArgument)\n\n        ' Retrieve the row that contains the button clicked by the user from the Rows collection. \n        Dim selectedRow As GridViewRow = GridView1.Rows(index)\n\n        ' Get the value of the column from the DataKeys using the row index\n        Dim id As String = e.CommandArgument.ToString()\n\n        ' Here you can add your delete logic\n        Response.Write("Deleting record with ID: " & id)\n    End If\nEnd Sub