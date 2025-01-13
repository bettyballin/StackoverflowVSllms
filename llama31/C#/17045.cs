private void dataGridView1_CellPainting(object sender, DataGridViewCellPaintingEventArgs e)\n{\n    if (e.RowIndex >= 0 && e.ColumnIndex >= 0)\n    {\n        if (dataGridView1.Rows[e.RowIndex].Selected)\n        {\n            e.Paint(e.CellBounds, DataGridViewPaintParts.All & ~DataGridViewPaintParts.Background);\n            using (Pen pen = new Pen(Color.Black, 2))\n            {\n                e.Graphics.DrawRectangle(pen, e.CellBounds);\n            }\n            e.Handled = true;\n        }\n    }\n}