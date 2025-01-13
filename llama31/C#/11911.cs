protected void GridView1_RowDataBound(object sender, GridViewRowEventArgs e)\n{\n    if (e.Row.RowType == DataControlRowType.DataRow)\n    {\n        // Get the data item bound to the row\n        DataRowView drv = (DataRowView)e.Row.DataItem;\n\n        // Create a hyperlink\n        HyperLink hl = new HyperLink();\n        hl.Text = drv["LinkText"].ToString();\n        hl.NavigateUrl = drv["LinkUrl"].ToString();\n\n        // Add the hyperlink to the row\n        e.Row.Cells[1].Controls.Add(hl); // Assuming the link should be in the second column\n    }\n}