// Handle registration form submission\nprotected void btnRegister_Click(object sender, EventArgs e)\n{\n    // Create a new account and associate the OpenID\n    var newAccount = CreateAccount(txtUsername.Text, txtEmail.Text, openid.Identity);\n    if (newAccount != null)\n    {\n        // Sign in the user using FormsAuthentication\n        FormsAuthentication.RedirectFromLoginPage(newAccount.Username, true);\n    }\n    else\n    {\n        // Handle registration errors\n    }\n}