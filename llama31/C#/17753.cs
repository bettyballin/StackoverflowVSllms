using System.Net;\n\n// Set the default proxy settings\nvar proxy = WebRequest.DefaultWebProxy;\nproxy.Credentials = CredentialCache.DefaultCredentials;\nWebRequest.DefaultWebProxy = proxy;