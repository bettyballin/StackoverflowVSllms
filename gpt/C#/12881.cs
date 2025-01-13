protected void LoginButton_Click(object sender, EventArgs e)\n{\n    string username = UsernameTextBox.Text;\n\n    if (Membership.ValidateUser(username, null))\n    {\n        FormsAuthentication.RedirectFromLoginPage(username, false);\n    }\n    else\n    {\n        // Invalid login\n        FailureText.Text = "Invalid username.";\n    }\n}