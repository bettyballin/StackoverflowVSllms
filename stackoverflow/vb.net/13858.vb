If DataGridView1.RowCount > 0 Then\n\n        Dim MyDesiredIndex As Integer = 0\n\n        If DataGridView1.CurrentRow.Index < DataGridView1.RowCount - 1 Then\n            MyDesiredIndex = DataGridView1.CurrentRow.Index + 1\n        End If\n\n        DataGridView1.ClearSelection()            \n        DataGridView1.CurrentCell = DataGridView1.Rows(MyDesiredIndex).Cells(0)\n        DataGridView1.Rows(MyDesiredIndex).Selected = True\n\n    End If