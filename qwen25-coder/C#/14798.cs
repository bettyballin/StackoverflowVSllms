using System;\nusing System.Net.Security;\nusing System.Net.Sockets;\nusing System.Security.Cryptography.X509Certificates;\n\npublic class Program\n{\n    public static void Main()\n    {\n        var server = new ServerEntry { Name = "www.example.com", Port = 443 };\n        GetCertificateChain(server);\n    }\n\n    private static SslStream OpenSslStream(ServerEntry server)\n    {\n        TcpClient client = null;\n        try\n        {\n            client = new TcpClient();\n            client.Connect(server.Name, server.Port);\n            var sslStream = new SslStream(client.GetStream(), false, ValidateServerCertificate, null);\n            sslStream.AuthenticateAsClient(server.Name);\n            return sslStream;\n        }\n        catch (Exception ex)\n        {\n            Console.WriteLine(ex.Message);\n            return null;\n        }\n        finally\n        {\n            client?.Close();\n        }\n    }\n\n    private static bool ValidateServerCertificate(object sender, X509Certificate certificate, X509Chain chain, SslPolicyErrors sslPolicyErrors)\n    {\n        // Save the chain for later use - this is very important!\n        var certStorePath = @"C:\Your\Desired\Path";\n        if (chain != null && chain.ChainElements != null)\n        {\n            foreach (X509ChainElement element in chain.ChainElements)\n            {\n                string certFileName = System.IO.Path.Combine(certStorePath, Guid.NewGuid().ToString() + ".cer");\n                System.IO.File.WriteAllBytes(certFileName, element.Certificate.Export(X509ContentType.Cert));\n                Console.WriteLine($"Saved certificate: {certFileName}");\n            }\n        }\n\n        return sslPolicyErrors == SslPolicyErrors.None; // In a real-world scenario, you should verify the certificate properly.\n    }\n\n    private static void GetCertificateChain(ServerEntry Server)\n    {\n        using (var newSslStream = OpenSslStream(Server))\n        {\n            if (newSslStream != null)\n            {\n                Console.WriteLine("SSL Stream established successfully.");\n            }\n        }\n    }\n}\n\npublic class ServerEntry\n{\n    public string Name { get; set; }\n    public int Port { get; set; }\n}