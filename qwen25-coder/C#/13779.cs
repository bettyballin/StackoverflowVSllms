protected void OnAuthenticate(object sender, AuthenticateEventArgs e)\n{\n    // Your authentication logic here\n\n    if (e.Authenticated)\n    {\n        FormsAuthentication.SetAuthCookie(UsernameTextBox.Text, RememberMeCheckBox.Checked);\n        Response.Redirect("http://yourdomain.com/default.aspx");\n    }\n}