[WebMethod]\npublic void MyJsonWebService()\n{\n    // Validate API Key\n    string apiKey = HttpContext.Current.Request.Headers["ApiKey"];\n    if (string.IsNullOrEmpty(apiKey) || apiKey != "YourSecretApiKey")\n    {\n        HttpContext.Current.Response.StatusCode = 403; // Forbidden\n        HttpContext.Current.Response.End();\n        return;\n    }\n\n    // Validate Referrer\n    string referrer = HttpContext.Current.Request.UrlReferrer?.Host;\n    if (string.IsNullOrEmpty(referrer) || referrer != "yourdomain.com")\n    {\n        HttpContext.Current.Response.StatusCode = 403; // Forbidden\n        HttpContext.Current.Response.End();\n        return;\n    }\n\n    // Process request and return JSON response\n    var response = new { message = "Success" };\n    HttpContext.Current.Response.ContentType = "application/json";\n    HttpContext.Current.Response.Write(JsonConvert.SerializeObject(response));\n}