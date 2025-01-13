protected void Application_BeginRequest(Object sender, EventArgs e)\n{\n    var request = HttpContext.Current.Request;\n    var response = HttpContext.Current.Response;\n\n    // Normalize URL for comparison\n    string requestedPath = request.Url.AbsolutePath.ToLowerInvariant();\n    \n    if (requestedPath.EndsWith("/default.aspx"))\n    {\n        // Perform a 301 redirect to the root URL\n        string redirectUrl = request.Url.GetLeftPart(UriPartial.Authority) + "/";\n        response.Status = "301 Moved Permanently";\n        response.AddHeader("Location", redirectUrl);\n        response.End();\n    }\n}