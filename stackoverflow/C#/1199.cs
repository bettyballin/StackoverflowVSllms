BasicHttpBinding b = new BasicHttpBinding();\nb.Security.Mode = BasicHttpSecurityMode.Transport ;\nb.Security.Transport.ClientCredentialType = HttpClientCredentialType.Windows;