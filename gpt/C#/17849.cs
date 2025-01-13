using System;\nusing System.Security.Cryptography;\nusing System.Security.Cryptography.X509Certificates;\n\npublic class CertificateGenerator\n{\n    public static X509Certificate2 CreateSelfSignedRootCertificate(string subjectName)\n    {\n        using (RSA rsa = RSA.Create(2048))\n        {\n            var request = new CertificateRequest(\n                $"CN={subjectName}",\n                rsa,\n                HashAlgorithmName.SHA256,\n                RSASignaturePadding.Pkcs1);\n\n            request.CertificateExtensions.Add(\n                new X509BasicConstraintsExtension(true, false, 0, true));\n            request.CertificateExtensions.Add(\n                new X509KeyUsageExtension(X509KeyUsageFlags.KeyCertSign | X509KeyUsageFlags.CrlSign, true));\n            request.CertificateExtensions.Add(\n                new X509SubjectKeyIdentifierExtension(request.PublicKey, false));\n\n            var rootCertificate = request.CreateSelfSigned(\n                DateTimeOffset.UtcNow.AddDays(-1),\n                DateTimeOffset.UtcNow.AddYears(10));\n\n            return new X509Certificate2(rootCertificate.Export(X509ContentType.Pfx));\n        }\n    }\n\n    public static X509Certificate2 CreateClientCertificate(string subjectName, X509Certificate2 issuerCertificate)\n    {\n        using (RSA rsa = RSA.Create(2048))\n        {\n            var request = new CertificateRequest(\n                $"CN={subjectName}",\n                rsa,\n                HashAlgorithmName.SHA256,\n                RSASignaturePadding.Pkcs1);\n\n            request.CertificateExtensions.Add(\n                new X509BasicConstraintsExtension(false, false, 0, false));\n            request.CertificateExtensions.Add(\n                new X509KeyUsageExtension(X509KeyUsageFlags.DigitalSignature, true));\n            request.CertificateExtensions.Add(\n                new X509EnhancedKeyUsageExtension(\n                    new OidCollection { new Oid("1.3.6.1.5.5.7.3.2") }, // Client Authentication\n                    true));\n            request.CertificateExtensions.Add(\n                new X509SubjectKeyIdentifierExtension(request.PublicKey, false));\n\n            var clientCertificate = request.Create(\n                issuerCertificate,\n                DateTimeOffset.UtcNow.AddDays(-1),\n                DateTimeOffset.UtcNow.AddYears(5),\n                new byte[] { 1, 2, 3, 4 });\n\n            return new X509Certificate2(clientCertificate.Export(X509ContentType.Pfx));\n        }\n    }\n\n    public static void Main()\n    {\n        var rootCert = CreateSelfSignedRootCertificate("RootCA");\n        var clientCert = CreateClientCertificate("ClientApp", rootCert);\n\n        Console.WriteLine("Root Certificate:");\n        Console.WriteLine(rootCert.ToString(true));\n\n        Console.WriteLine("Client Certificate:");\n        Console.WriteLine(clientCert.ToString(true));\n    }\n}