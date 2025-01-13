using System;\nusing System.Net.Security;\nusing System.IO;\nusing System.Net.Sockets;\nusing System.Security.Authentication;\nusing System.Security.Cryptography.X509Certificates;\n\npublic static void StartClient()\n{\n    string certificatePath = "path_to_client.pfx";\n    string certificatePassword = "certificate_password";\n\n    using (TcpClient client = new TcpClient("localhost", 8443))\n    {\n        SslStream sslStream = new SslStream(client.GetStream(), false,\n            RemoteCertificateValidationCallback delegate { return true; },\n            (sender, targetHost) => \n                new X509Certificate2(certificatePath, certificatePassword));\n\n        sslStream.AuthenticateAsClient(targetHost: "", clientCertificates: null, enabledSslProtocols: SslProtocols.Tls12 | SslProtocols.Tls13,\n            checkCertificateRevocationList: false);\n\n        // Perform SSL/TLS communication here\n    }\n}