protected void Application_AuthenticateRequest(Object sender, EventArgs e)\n{\n    if (Context.Request.HttpMethod == "POST" && Context.Request.Form["username"] != null && Context.Request.Form["password"] != null)\n    {\n        string username = Context.Request.Form["username"];\n        string password = Context.Request.Form["password"];\n\n        // Custom validation logic\n        bool isValidUser = ValidateUser(username, password);\n\n        if (isValidUser)\n        {\n            // Set up Forms Authentication ticket, and authenticate user\n            var authTicket = new FormsAuthenticationTicket(1, username, DateTime.Now, DateTime.Now.AddMinutes(20), false, string.Empty);\n            string encryptedTicket = FormsAuthentication.Encrypt(authTicket);\n            HttpCookie authCookie = new HttpCookie(FormsAuthentication.FormsCookieName, encryptedTicket);\n            Context.Response.Cookies.Add(authCookie);\n        }\n        else\n        {\n            // Handle authentication failure\n            Context.Response.Status = "401 Unauthorized";\n            Context.Response.End();\n        }\n    }\n}\n\nprivate bool ValidateUser(string username, string password)\n{\n    // Implement your custom authentication logic here\n    return (username == "expectedUsername" && password == "expectedPassword");\n}