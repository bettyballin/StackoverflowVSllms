using System;\nusing System.Security.Cryptography.X509Certificates;\n\nclass Program\n{\n    static void Main()\n    {\n        string pfxFilePath = "path_to_your_pfx_file.pfx";\n        string pfxPassword = "your_pfx_password";\n\n        // Load the certificate with private key from the .pfx file\n        X509Certificate2 certificate = new X509Certificate2(pfxFilePath, pfxPassword, X509KeyStorageFlags.MachineKeySet | X509KeyStorageFlags.PersistKeySet | X509KeyStorageFlags.Exportable);\n\n        // Open the Local Machine store\n        using (X509Store store = new X509Store(StoreName.My, StoreLocation.LocalMachine))\n        {\n            store.Open(OpenFlags.ReadWrite);\n            store.Add(certificate);\n            store.Close();\n        }\n\n        Console.WriteLine("Certificate imported successfully.");\n    }\n}