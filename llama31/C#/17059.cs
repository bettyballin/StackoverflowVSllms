X509Certificate cert = new X509Certificate("path/to/client/certificate.pfx", "password");\nWebRequest request = WebRequest.Create("https://example.com");\nrequest.ClientCertificates.Add(cert);