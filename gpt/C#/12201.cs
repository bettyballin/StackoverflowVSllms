protected void btnTimeIn_Click(object sender, EventArgs e)\n{\n    Button btnTimeIn = (Button)sender;\n    GridViewRow row = (GridViewRow)btnTimeIn.NamingContainer;\n    Button btnTimeOut = (Button)row.FindControl("btnTimeOut");\n\n    btnTimeIn.Visible = false;\n    btnTimeOut.Visible = true;\n}\n\nprotected void btnTimeOut_Click(object sender, EventArgs e)\n{\n    Button btnTimeOut = (Button)sender;\n    GridViewRow row = (GridViewRow)btnTimeOut.NamingContainer;\n    Button btnTimeIn = (Button)row.FindControl("btnTimeIn");\n\n    btnTimeOut.Visible = false;\n    btnTimeIn.Visible = true;\n}