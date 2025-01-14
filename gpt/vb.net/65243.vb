Protected Sub GridView1_RowDeleting(sender As Object, e As GridViewDeleteEventArgs)\n    ' Get the DataTable from your data source\n    Dim tempTable As DataTable = CType(Session("temptable"), DataTable)\n\n    ' Get the index of the row to be deleted\n    Dim rowIndex As Integer = e.RowIndex\n\n    ' Find the DataRow in the DataTable using the index\n    Dim rowToDelete As DataRow = tempTable.Rows(rowIndex)\n\n    ' Delete the DataRow\n    rowToDelete.Delete()\n\n    ' Optionally, update the data source if necessary\n    ' For example, if you are using a DataSet, you may need to call AcceptChanges\n    tempTable.AcceptChanges()\n\n    ' Rebind the GridView to reflect changes\n    GridView1.DataSource = tempTable\n    GridView1.DataBind()\nEnd Sub