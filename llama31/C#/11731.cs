private void Form1_Load(object sender, EventArgs e)\n{\n    dataGridView1.Sort(dataGridView1.Columns["Name"], ListSortDirection.Ascending, \n        new System.ComponentModel.SortComparer<string>((a, b) => string.Compare(a, b, StringComparison.OrdinalIgnoreCase)));\n}