[WebMethod(EnableSession = true)]\npublic string Method(string param1, string param2)\n{\n    if (HttpContext.Current.Session == null || HttpContext.Current.Session.IsNewSession /* Additional checks for session timeout */)\n    {\n        return "SESSION_EXPIRED";\n    }\n    // Your method logic here\n}