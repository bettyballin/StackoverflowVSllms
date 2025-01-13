protected void Page_Load(object sender, EventArgs e)\n{\n    if (!IsPostBack)\n    {\n        // Always use server paths or map paths for web applications.\n        string path = Server.MapPath("~/MyPix");\n        \n        // Ensure directory exists before attempting to get files.\n        DirectoryInfo dirInfo = new DirectoryInfo(path);\n        if (dirInfo.Exists)\n        {\n            Repeater1.DataSource = dirInfo.GetFiles();\n            Repeater1.DataBind();\n        }\n    }\n}