protected void LogoutButton_Click(object sender, EventArgs e)\n{\n    FormsAuthentication.SignOut();\n    Session.Abandon(); // Abandon session to clear session state.\n    Response.Redirect("Login.aspx"); // Redirect to login page.\n}