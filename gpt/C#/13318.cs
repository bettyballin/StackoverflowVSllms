protected void LogoutButton_Click(object sender, EventArgs e)\n{\n    Session.Abandon();\n    Response.Cookies["ASP.NET_SessionId"].Expires = DateTime.Now.AddDays(-1);\n    // Redirect to login or home page\n    Response.Redirect("Login.aspx");\n}