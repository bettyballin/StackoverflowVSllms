using System;\nusing System.Security.Cryptography;\n\nclass Program\n{\n    static void Main()\n    {\n        // Generate a new RSA key pair\n        using (RSACryptoServiceProvider rsa = new RSACryptoServiceProvider(2048))\n        {\n            // Export the private key\n            string privateKeyXml = rsa.ToXmlString(true);\n\n            // Create a new RSA instance and import the private key\n            using (RSACryptoServiceProvider rsaPrivate = new RSACryptoServiceProvider())\n            {\n                rsaPrivate.FromXmlString(privateKeyXml);\n\n                // Export the public key from the private key\n                string publicKeyXml = rsaPrivate.ToXmlString(false);\n\n                Console.WriteLine("Public Key: ");\n                Console.WriteLine(publicKeyXml);\n            }\n        }\n    }\n}