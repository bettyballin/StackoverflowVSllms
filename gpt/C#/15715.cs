using System;\nusing System.Net;\nusing System.Net.Security;\nusing System.Security.Cryptography.X509Certificates;\n\nclass Program\n{\n    static void Main()\n    {\n        ServicePointManager.ServerCertificateValidationCallback = ValidateServerCertificate;\n\n        // Your HTTPWebRequest code here\n\n    }\n\n    private static bool ValidateServerCertificate(\n        object sender,\n        X509Certificate certificate,\n        X509Chain chain,\n        SslPolicyErrors sslPolicyErrors)\n    {\n        if (sslPolicyErrors == SslPolicyErrors.None)\n        {\n            return true; // No errors, certificate is valid\n        }\n\n        if ((sslPolicyErrors & SslPolicyErrors.RemoteCertificateNameMismatch) != 0)\n        {\n            Console.WriteLine("Certificate name mismatch.");\n            return false;\n        }\n\n        if ((sslPolicyErrors & SslPolicyErrors.RemoteCertificateChainErrors) != 0)\n        {\n            Console.WriteLine("Chain error.");\n            foreach (X509ChainStatus status in chain.ChainStatus)\n            {\n                Console.WriteLine($"Chain error: {status.StatusInformation}");\n            }\n            return false;\n        }\n\n        if ((sslPolicyErrors & SslPolicyErrors.RemoteCertificateNotAvailable) != 0)\n        {\n            Console.WriteLine("Certificate not available.");\n            return false;\n        }\n\n        // Log other potential issues\n        Console.WriteLine($"SSL Policy Errors: {sslPolicyErrors}");\n        return false; // Or implement additional checks as needed\n    }\n}