protected void Page_Load(object sender, EventArgs e)\n{\n    if (!IsPostBack)\n    {\n        lstItems.DataSource = // your data source here\n        lstItems.DataBind();\n    }\n}