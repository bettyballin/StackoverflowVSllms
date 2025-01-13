private void dataGridView1_RowPostPaint(object sender, DataGridViewRowPostPaintEventArgs e)\n{\n    if (dataGridView1.Rows[e.RowIndex].Selected)\n    {\n        using (Pen selectionBorder = new Pen(Color.Black)) // Customize Color as needed\n        {\n            var rect = dataGridView1.GetRowDisplayRectangle(e.RowIndex, true);\n            // Adjust rectangle to make the border visible outside the cell boundaries\n            rect.X -= 1;\n            rect.Y -= 1;\n            rect.Width += 2;\n            rect.Height += 2;\n\n            // Draw Border Around Selected Row\n            e.Graphics.DrawRectangle(selectionBorder, rect);\n        }\n    }\n}