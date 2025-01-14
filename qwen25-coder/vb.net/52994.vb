' Assuming you have a DataGridView named 'dataGridView1'\nPrivate Sub dataGridView1_RowsAdded(sender As Object, e As DataGridViewRowsAddedEventArgs) Handles dataGridView1.RowsAdded\n    If e.RowIndex >= 0 Then\n        Dim comboBoxCell As DataGridViewComboBoxCell = CType(dataGridView1.Rows(e.RowIndex).Cells("VAT Rate"), DataGridViewComboBoxCell)\n\n        ' Set default value if needed (assuming "Standard" is a known item)\n        comboBoxCell.Value = "Standard"\n\n        ' Example: Change items based on some condition\n        ' This is just an example; replace with your business logic\n        Dim shouldChangeItems As Boolean = True  ' Replace with actual logic\n\n        If shouldChangeItems Then\n            ' Clear existing items and add new ones based on logic\n            comboBoxCell.Items.Clear()\n            comboBoxCell.Items.Add("Special Rate")\n            comboBoxCell.Items.Add("Exempt")\n        End If\n    End If\nEnd Sub