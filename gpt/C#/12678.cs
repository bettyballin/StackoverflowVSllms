protected void Page_Load(object sender, EventArgs e)\n{\n    if (!IsPostBack)\n    {\n        // Initialize ViewState\n        ViewState["UserInput"] = string.Empty;\n    }\n}\n\nprotected void Button1_Click(object sender, EventArgs e)\n{\n    // Save the user input in ViewState\n    ViewState["UserInput"] = TextBox1.Text;\n    Label1.Text = "You entered: " + ViewState["UserInput"].ToString();\n}