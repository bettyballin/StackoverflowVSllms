Protected Sub GridView1_RowDataBound(ByVal sender As Object, ByVal e As System.Web.UI.WebControls.GridViewRowEventArgs) Handles GridView1.RowDataBound\n\n    If e.Row.RowType = DataControlRowType.Header Then\n        ' Create a new row for the filter controls\n        Dim filterRow As New GridViewRow(-1, -1, DataControlRowType.Header, DataControlRowState.Normal)\n\n        For Each column As DataControlField In CType(sender, GridView).Columns\n            Dim cell As New TableCell()\n\n            Select Case column.SortExpression\n                Case "ColumnName1" ' Replace with actual column name that needs dropdown filter\n                    Dim ddl As New DropDownList()\n                    ddl.ID = String.Format("ddlFilter{0}", column.SortExpression)\n                    '' add your items to the ddl here\n                    cell.Controls.Add(ddl)\n\n                Case "ColumnName2" ' Replace with actual column name that needs textbox search\n                    Dim txtSearch As New TextBox()\n                    txtSearch.ID = String.Format("txtSearch{0}", column.SortExpression)\n                    cell.Controls.Add(txtSearch)\n\n                Case Else\n                    ' If no specific control is needed, you can add a label or an empty literal\n                    cell.Controls.Add(New LiteralControl(" "))\n            End Select\n\n            filterRow.Cells.Add(cell)\n        Next\n\n        ' Add the new filter row right after the existing header row\n        GridView1.HeaderRow.Parent.Controls.AddAt(1, filterRow) ' Add it at position 1 (after the original header)\n\n    End If\nEnd Sub