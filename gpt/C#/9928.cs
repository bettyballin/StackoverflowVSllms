protected void Application_BeginRequest(Object sender, EventArgs e)\n{\n    string rawUrl = HttpContext.Current.Request.RawUrl.ToLower();\n\n    if (rawUrl == "/abc")\n    {\n        HttpContext.Current.Response.RedirectPermanent("/default.aspx?article=abc");\n    }\n}