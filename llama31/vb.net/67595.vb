Dim dgv As DataGridView = AssetDataGridView\nDim column As New DataGridViewForeignKeyColumn()\ncolumn.DataPropertyName = "CategoryID"\ncolumn.HeaderText = "Category"\ndgv.Columns.Add(column)