protected void Application_BeginRequest(object sender, EventArgs e)\n{\n    // Check for IE6 in User Agent string\n    if (Request.UserAgent != null && Request.UserAgent.IndexOf("Mozilla/4.0", StringComparison.OrdinalIgnoreCase) >= 0 &&\n        Request.UserAgent.IndexOf("MSIE 6", StringComparison.OrdinalIgnoreCase) >= 0)\n    {\n        string url = "http://www.example-no-compression.com" + Request.Url.PathAndQuery;\n\n        // Preserving POST data requires more sophisticated handling\n        if (Request.HttpMethod == "POST")\n        {\n            // You'd need to create a form submission script on the destination page\n            string bodyContent = "<html><head></head><body>";\n            foreach (string key in Request.Form.Keys)\n            {\n                bodyContent += $"<input type=\"hidden\" name=\"{key}\" value=\"{Request.Form[key]}\" />";\n            }\n            bodyContent += "<script>window.onload=function(){document.forms[0].submit()};</script><form method=\"POST\" action=\"" + url + "\"></form></body></html>";\n            Response.Write(bodyContent);\n        }\n        else\n        {\n            // Redirect for GET requests\n            Response.Redirect(url, true);\n        }\n    }\n}