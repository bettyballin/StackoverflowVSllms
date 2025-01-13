using System;\nusing System.Net.Security;\nusing System.IO;\nusing System.Net.Sockets;\nusing System.Security.Cryptography.X509Certificates;\n\npublic class PeerToPeerSslExample\n{\n    private static X509Certificate2 LoadOrGenerateCertificate()\n    {\n        string certPath = "selfsigned.pfx";\n        if (!File.Exists(certPath))\n        {\n            // Generate a new self-signed certificate if it doesn't exist\n            using (var rsa = RSA.Create(2048))\n            {\n                var certRequest = new CertificateRequest(\n                    "CN=Peer",\n                    rsa,\n                    System.Security.Cryptography.HashAlgorithmName.SHA256,\n                    RSASignaturePadding.Pkcs1);\n\n                var cert = certRequest.CreateSelfSigned(DateTimeOffset.Now, DateTimeOffset.Now.AddYears(1));\n                var bytes = cert.Export(X509ContentType.Pfx);\n                File.WriteAllBytes(certPath, bytes);\n                return new X509Certificate2(bytes);\n            }\n        }\n        else\n        {\n            // Load existing certificate if it exists\n            return new X509Certificate2(certPath);\n        }\n    }\n\n    private static bool CustomValidationCallback(\n        object sender,\n        X509Certificate certificate,\n        X509Chain chain,\n        SslPolicyErrors sslPolicyErrors)\n    {\n        // Validate the remote certificate against your known certificate\n        var trustedCert = File.ReadAllBytes("trusted_peer.cer");\n        return new X509Certificate2(trustedCert).GetRawCertData().SequenceEqual(certificate.GetRawCertData());\n    }\n\n    public static void Main(string[] args)\n    {\n        var localCert = LoadOrGenerateCertificate();\n        TcpClient client = new TcpClient("localhost", 1234);\n        using (var sslStream = new SslStream(client.GetStream(), false, CustomValidationCallback))\n        {\n            // Authenticate as server or client based on your application logic\n            sslStream.AuthenticateAsClient(null, new X509Certificate2Collection(localCert), System.Security.Authentication.SslProtocols.Tls13, true);\n\n            // Perform secure data exchange here...\n        }\n    }\n}