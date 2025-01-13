using System.Security.Cryptography.X509Certificates;\n\n// Load the self-signed certificate\nX509Certificate2 certificate = new X509Certificate2("path/to/certificate.pfx", "password");\n\n// Add the certificate to the trusted store\nX509Store store = new X509Store(StoreName.Root, StoreLocation.LocalMachine);\nstore.Open(OpenFlags.ReadWrite);\nstore.Add(certificate);\nstore.Close();