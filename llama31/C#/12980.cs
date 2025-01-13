protected void Application_BeginRequest(object sender, EventArgs e)\n{\n    var request = ((HttpApplication)sender).Request;\n    var response = ((HttpApplication)sender).Response;\n\n    if (request.Url.AbsolutePath.EndsWith("abc", StringComparison.OrdinalIgnoreCase))\n    {\n        response.RedirectLocation = "/default.aspx?article=abc";\n        response.StatusCode = 301;\n        response.StatusDescription = "Moved";\n        response.End();\n    }\n}