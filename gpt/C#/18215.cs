using System;\nusing System.IO;\nusing System.Net;\nusing System.Net.Sockets;\nusing System.Security.Cryptography.X509Certificates;\nusing System.Net.Security;\n\nclass SslServer\n{\n    public static void Main(string[] args)\n    {\n        X509Certificate2 serverCertificate = GenerateSelfSignedCertificate("CN=Server");\n\n        TcpListener listener = new TcpListener(IPAddress.Any, 8080);\n        listener.Start();\n        Console.WriteLine("Waiting for a client to connect...");\n\n        TcpClient client = listener.AcceptTcpClient();\n        SslStream sslStream = new SslStream(client.GetStream(), false, new RemoteCertificateValidationCallback(ValidateClientCertificate));\n\n        try\n        {\n            sslStream.AuthenticateAsServer(serverCertificate, true, System.Security.Authentication.SslProtocols.Tls12, false);\n            Console.WriteLine("Client authenticated.");\n            // Handle communication...\n        }\n        catch (Exception ex)\n        {\n            Console.WriteLine("Exception: {0}", ex.Message);\n        }\n        finally\n        {\n            client.Close();\n            listener.Stop();\n        }\n    }\n\n    private static bool ValidateClientCertificate(object sender, X509Certificate certificate, X509Chain chain, SslPolicyErrors sslPolicyErrors)\n    {\n        if (sslPolicyErrors == SslPolicyErrors.None)\n            return true;\n\n        // Compare the received certificate with the known certificate\n        X509Certificate2 knownClientCertificate = new X509Certificate2("path_to_known_client_certificate.crt");\n        return certificate.Equals(knownClientCertificate);\n    }\n\n    private static X509Certificate2 GenerateSelfSignedCertificate(string subjectName)\n    {\n        // Generate self-signed certificate\n        // For simplicity, using BouncyCastle or other libraries is recommended for real projects.\n        // Placeholder code, replace with actual certificate generation logic\n        return new X509Certificate2();\n    }\n}