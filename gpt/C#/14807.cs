var client = new YourServiceClient();\nclient.ClientCredentials.ClientCertificate.SetCertificate(\n    StoreLocation.LocalMachine,\n    StoreName.My,\n    X509FindType.FindByThumbprint,\n    "your-client-certificate-thumbprint");\nclient.ClientCredentials.UserName.UserName = "ratfink";\nclient.ClientCredentials.UserName.Password = "testpassword";