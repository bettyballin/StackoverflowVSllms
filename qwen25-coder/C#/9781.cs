// Creating a FormsAuthentication Ticket\n   FormsAuthenticationTicket authTicket = new FormsAuthenticationTicket(\n       1, \n       username, \n       DateTime.Now, \n       DateTime.Now.AddMinutes(30), \n       false, \n       userId);\n\n   string encryptedTicket = FormsAuthentication.Encrypt(authTicket);\n   HttpCookie authCookie = new HttpCookie(FormsAuthentication.FormsCookieName, encryptedTicket) { HttpOnly = true };\n   Response.Cookies.Add(authCookie);