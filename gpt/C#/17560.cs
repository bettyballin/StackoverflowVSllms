protected void Page_Load(object sender, EventArgs e)\n{\n    if (!IsUserLoggedIn())\n    {\n        Response.Redirect("LogIn.aspx");\n    }\n}