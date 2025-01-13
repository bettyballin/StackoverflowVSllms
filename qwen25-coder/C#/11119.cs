protected void Application_AuthenticateRequest(Object sender, EventArgs e)\n{\n    if (HttpContext.Current.User != null && HttpContext.Current.User.Identity.IsAuthenticated)\n    {\n        // If user information not in session or session expired, reload it from auth ticket.\n        if (Session["UserID"] == null || Session["Email"] == null)\n        {\n            FormsIdentity ident = (FormsIdentity)HttpContext.Current.User.Identity;\n            FormsAuthenticationTicket authTicket = ident.Ticket;\n\n            string userData = authTicket.UserData;\n            var principal = new ClaimsPrincipal(ident);\n            \n            Session["UserID"] = principal.FindFirst(ClaimTypes.NameIdentifier)?.Value;\n            Session["Email"] = principal.FindFirst(ClaimTypes.Email)?.Value;\n            // Load other necessary data similarly.\n        }\n    }\n}