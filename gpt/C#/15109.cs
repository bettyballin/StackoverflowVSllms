protected void Page_Load(object sender, EventArgs e)\n{\n    int i = 1; // Example value, set this as needed\n\n    DropDownList ddl = new DropDownList();\n    ddl.ID = "AdTitle" + i;\n    \n    // Add items to the DropDownList if needed\n    ddl.Items.Add(new ListItem("Option 1", "1"));\n    ddl.Items.Add(new ListItem("Option 2", "2"));\n\n    // Add the DropDownList to the placeholder\n    PlaceHolder1.Controls.Add(ddl);\n}