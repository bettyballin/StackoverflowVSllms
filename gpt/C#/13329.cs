protected void Session_Start(object sender, EventArgs e)\n{\n    HttpContext.Current.Session.Timeout = 1440; // 24 hours\n    HttpCookie cookie = HttpContext.Current.Request.Cookies["ASP.NET_SessionId"];\n    if (cookie != null)\n    {\n        cookie.Expires = DateTime.MinValue; // ensures the cookie is session-only\n        HttpContext.Current.Response.Cookies.Set(cookie);\n    }\n}