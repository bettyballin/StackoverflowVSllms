protected void Button1_Click(object sender, EventArgs e)\n{\n    int count = 0;\n\n    if (ViewState["ButtonCount"] != null)\n    {\n        count = (int)ViewState["ButtonCount"];\n    }\n\n    count++;\n    ViewState["ButtonCount"] = count;\n\n    for (int i = 0; i < count; i++)\n    {\n        Literal literal = new Literal();\n        literal.Text = DateTime.Now.ToString();\n        literal.ID = DateTime.Now.Ticks.ToString();\n\n        UpdatePanel1.ContentTemplateContainer.Controls.Add(literal);\n        PlaceHolder1.Controls.Add(literal);\n    }            \n}