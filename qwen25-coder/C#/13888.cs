private void Form1_Load(object sender, EventArgs e)\n{\n    // Ensure DataGridView is populated before sorting\n    if (dataGridView1.Columns["Name"] != null && dataGridView1.Rows.Count > 0)\n    {\n        // Sort by Name column in ascending order\n        dataGridView1.Sort(dataGridView1.Columns["Name"], System.ComponentModel.ListSortDirection.Ascending);\n    }\n}