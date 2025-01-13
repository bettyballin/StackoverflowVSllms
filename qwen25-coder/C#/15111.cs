using System;\nusing System.IO;\nusing System.Security.Cryptography.X509Certificates;\n\nclass CertificateManager\n{\n    private string CertDirectory = @"C:\MyApp\Certs";\n\n    public void CheckExpiringCertificates()\n    {\n        var certFiles = Directory.GetFiles(CertDirectory, "*.pfx");\n\n        foreach (var file in certFiles)\n        {\n            using (X509Certificate2 cert = new X509Certificate2(file))\n            {\n                if (cert.NotAfter < DateTime.Now.AddDays(30)) // Check for certificates expiring within 30 days\n                {\n                    Console.WriteLine($"Certificate {cert.Subject} expires on {cert.NotAfter}");\n                }\n            }\n        }\n    }\n}\n\nclass Program\n{\n    static void Main(string[] args)\n    {\n        var manager = new CertificateManager();\n        manager.CheckExpiringCertificates();\n    }\n}