using System;\nusing System.Security.Cryptography.X509Certificates;\n\nclass Program\n{\n    static void Main()\n    {\n        // Create a new RSA key pair\n        using (var rsa = RSA.Create(2048))\n        {\n            var request = new CertificateRequest(\n                "cn=YourCompanyNameRootCA, o=YourCompany, c=Country",\n                rsa,\n                HashAlgorithmName.SHA256,\n                RSASignaturePadding.Pkcs1);\n\n            // Create a self-signed certificate\n            using (X509Certificate2 rootCert = request.CreateSelfSigned(DateTimeOffset.Now, DateTimeOffset.Now.AddYears(1)))\n            {\n                var pfxBlob = rootCert.Export(X509ContentType.Pfx);\n                File.WriteAllBytes("YourCompanyRootCA.pfx", pfxBlob);\n\n                Console.WriteLine("Root certificate created and saved to YourCompanyRootCA.pfx");\n            }\n        }\n    }\n}