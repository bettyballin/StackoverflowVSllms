IWebProxy proxy = WebRequest.DefaultWebProxy;\nif (proxy != null && proxy.UseDefaultCredentials)\n{\n    // Proxy authentication is required, use default credentials\n    proxy.Credentials = CredentialCache.DefaultCredentials;\n}