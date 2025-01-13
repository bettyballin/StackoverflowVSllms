class Program\n{\n    static void Main()\n    {\n        // Load the certificate from file\n        string certPath = @"path\to\your\certificate.cer";\n        X509Certificate2 certificate = new X509Certificate2(certPath);\n\n        // Display some basic information about this certificate.\n        Console.WriteLine("Subject: {0}", certificate.Subject);\n        Console.WriteLine("Issuer: {0}", certificate.Issuer);\n        Console.WriteLine("Thumbprint: {0}", certificate.Thumbprint);\n        Console.WriteLine("Version: {0}", certificate.Version);\n        Console.WriteLine("Serial Number: {0}", certificate.SerialNumber);\n        Console.WriteLine("Effective Date: {0}", certificate.GetEffectiveDateString());\n        Console.WriteLine("Expiry Date: {0}", certificate.GetExpirationDateString());\n\n        // Additional checks and uses can be added here\n    }\n}