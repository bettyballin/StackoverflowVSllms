protected void btn_editShowings_Click(object sender, EventArgs e)\n{\n    // ...\n\n    Control control = pnl_showings.FindControl("showing_1");\n    if (control != null)\n    {\n        control.Visible = false;\n    }\n}