// Web.config authentication setting\n<authentication mode="Forms">\n  <forms loginUrl="Login.aspx" timeout="30" />\n</authentication>\n\n// Example of a secure web method in ASP.NET Web Services\n[WebMethod(EnableSession = true)]\npublic string GetSecureData()\n{\n    if (HttpContext.Current.User.Identity.IsAuthenticated)\n    {\n        // Further authorization checks can be added here\n        return "Sensitive Data";\n    }\n    throw new UnauthorizedAccessException("User is not authenticated.");\n}