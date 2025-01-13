using System.Net;\n\n// Create a web request to the web service\nWebRequest request = WebRequest.Create("https://example.com/service");\n\n// Set the authentication credentials to the default credentials\nrequest.Credentials = CredentialCache.DefaultCredentials;\n\n// Get the response from the web service\nWebResponse response = request.GetResponse();