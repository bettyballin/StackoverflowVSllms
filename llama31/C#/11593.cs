private void dataGridView1_KeyDown(object sender, KeyEventArgs e)\n{\n    if (e.KeyCode == Keys.Enter)\n    {\n        e.Handled = true;\n        int columnIndex = dataGridView1.CurrentCell.ColumnIndex;\n        int rowIndex = dataGridView1.CurrentCell.RowIndex;\n        if (columnIndex < dataGridView1.Columns.Count - 1)\n        {\n            dataGridView1.CurrentCell = dataGridView1.Rows[rowIndex].Cells[columnIndex + 1];\n        }\n    }\n}