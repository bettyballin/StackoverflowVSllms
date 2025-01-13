private void dataGridView1_CellPainting(object sender, DataGridViewCellPaintingEventArgs e)\n{\n    if (e.RowIndex >= 0 && e.ColumnIndex >= 0)\n    {\n        DataGridView dgv = sender as DataGridView;\n        if (dgv.CurrentCell != null && \n            e.RowIndex == dgv.CurrentCell.RowIndex && \n            e.ColumnIndex == dgv.CurrentCell.ColumnIndex)\n        {\n            e.Paint(e.CellBounds, DataGridViewPaintParts.All & ~DataGridViewPaintParts.Background);\n            using (Brush backColorBrush = new SolidBrush(Color.Yellow)) // Customize the color as needed\n            {\n                e.Graphics.FillRectangle(backColorBrush, e.CellBounds);\n            }\n            e.Handled = true;\n        }\n    }\n}\n\nprivate void Form1_Load(object sender, EventArgs e)\n{\n    // Assuming dataGridView1 is your DataGridView\n    dataGridView1.CellPainting += dataGridView1_CellPainting;\n}