protected void Application_AuthenticateRequest(Object sender, EventArgs e)\n{\n    if (!AuthHelper.ValidateUser(HttpContext.Current.Request))\n    {\n        // Redirect to login page or show unauthorized access\n        HttpContext.Current.Response.Redirect("/login.aspx");\n    }\n}