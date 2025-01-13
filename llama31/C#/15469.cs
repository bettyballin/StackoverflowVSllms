protected void GridView1_RowDataBound(object sender, GridViewRowEventArgs e)\n{\n    if (e.Row.RowType == DataControlRowType.Header)\n    {\n        for (int i = 0; i < e.Row.Cells.Count; i++)\n        {\n            if (i == 0 || i == 1 || i == 2) // Hide columns 0, 1, and 2\n            {\n                e.Row.Cells[i].Visible = false;\n            }\n        }\n    }\n}