Private Sub btnSort_Click(sender As Object, e As EventArgs) Handles btnSort.Click\n    ' Example sorted columns from your dialog\n    Dim sortColumns(2) As String\n    sortColumns(0) = "Column1 ASC"\n    sortColumns(1) = "Column2 DESC"\n\n    ' Building the sort string\n    Dim fullSortString As String = String.Join(",", sortColumns.Where(Function(s) Not String.IsNullOrEmpty(s)))\n\n    ' Set the Sort property of BindingSource\n    If Not String.IsNullOrEmpty(fullSortString) Then\n        bindingSource1.Sort = fullSortString\n    Else\n        bindingSource1.RemoveSort() ' To remove any existing sort\n    End If\n\n    ' Ensure DataGridView is bound to the BindingSource\n    dataGridView1.DataSource = bindingSource1\nEnd Sub