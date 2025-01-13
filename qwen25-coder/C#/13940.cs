protected void SafeRedirect(string url)\n{\n    // Validate and sanitize the URL if necessary\n    Response.Redirect(Server.UrlEncode(url));\n}\n\nprotected void SetSafeCookie(string name, string value)\n{\n    HttpCookie cookie = new HttpCookie(name, Server.UrlEncode(value));\n    Response.Cookies.Add(cookie);\n}