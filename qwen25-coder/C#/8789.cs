protected void Page_Load(object sender, EventArgs e)\n{\n    if (!IsPostBack)\n    {\n        // Initialize or perform any necessary actions during first load.\n    }\n\n    this.ValidateJavaScript();\n}\n\nprivate bool IsJavaScriptEnabled()\n{\n    return "true".Equals(this.ClientIDHiddenField.Value);\n}