protected void GridView1_RowEditing(object sender, GridViewEditEventArgs e)\n{\n    GridView1.Rows[e.NewEditIndex].Cells[1].Text = HttpUtility.HtmlDecode(GridView1.Rows[e.NewEditIndex].Cells[1].Text);\n}