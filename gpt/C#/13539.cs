using (RSACryptoServiceProvider rsa = new RSACryptoServiceProvider())\n    {\n        rsa.ImportParameters(senderPrivateKey);\n        using (SHA256 sha256 = SHA256.Create())\n        {\n            byte[] hash = sha256.ComputeHash(encryptedData);\n            byte[] signature = rsa.SignHash(hash, CryptoConfig.MapNameToOID("SHA256"));\n            // Save or transmit the signature along with the encryptedData\n        }\n    }