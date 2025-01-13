private void DataGridView1_AutoGeneratingColumn(object sender, DataGridViewAutoGeneratingColumnEventArgs e)\n{\n    if (e.ColumnType == typeof(DataGridViewTextBoxColumn))\n    {\n        DataGridViewTextBoxColumn column = e.Column as DataGridViewTextBoxColumn;\n        column.CellTemplate = new DataGridViewTextBoxCell();\n    }\n}