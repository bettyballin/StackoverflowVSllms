protected void Page_Load(object sender, EventArgs e)\n{\n    if (!IsPostBack)\n    {\n        // Assuming 'i' is an integer defined somewhere in your page or class\n        int i = 1; \n        DropDownList newDropDownList = new DropDownList();\n        newDropDownList.ID = "AdTitle" + i;\n        \n        // Add the new DropDownList to a container, e.g., a PlaceHolder\n        Controls.Add(newDropDownList);\n    }\n}