using System;\nusing System.Text;\n\nnamespace Agnus.Cipher\n{\n    class Program\n    {\n        static void Main()\n        {\n            // Create instances for sender and receiver\n            RSA sender = new RSA();\n            RSA receiver = new RSA();\n\n            // Exchange public keys (in real-world scenarios, you would send the key over a secure channel)\n            string senderPublicKey = sender.PublicKey;\n            receiver.InitializeRSAProviderOther(senderPublicKey);\n\n            // Sender side: Encrypt message\n            string originalMessage = "Hello, Secure World!";\n            byte[] plaintextBytes = Encoding.UTF8.GetBytes(originalMessage);\n            sender.plaintextBytes = plaintextBytes;  // Set the message to encrypt\n\n            byte[] encryptedData = sender.Encrypt();\n\n            // Simulate sending data over network (e.g., as a base64 string)\n            string encryptedDataBase64 = Convert.ToBase64String(encryptedData);\n\n            Console.WriteLine("Encrypted: " + encryptedDataBase64);\n\n            // Receiver side: Decrypt message\n            byte[] receivedEncryptedData = Convert.FromBase64String(encryptedDataBase64);\n            receiver.ciphertextBytes = receivedEncryptedData;\n\n            byte[] decryptedData = receiver.Decrypt();\n            string decryptedMessage = Encoding.UTF8.GetString(decryptedData);\n\n            Console.WriteLine("Decrypted: " + decryptedMessage);\n\n            // Example of signing and verifying data\n            byte[] signature = sender.Sign();  // Sign the encrypted data\n\n            bool isVerified = Verify(sender.PublicKey, receivedEncryptedData, signature);\n            Console.WriteLine("Is message verified? " + isVerified);\n        }\n\n        static bool Verify(string publicKeyString, byte[] data, byte[] signature)\n        {\n            using (RSACryptoServiceProvider rsaProvider = new RSACryptoServiceProvider())\n            {\n                rsaProvider.FromXmlString(publicKeyString);\n\n                using (SHA1Managed SHA1 = new SHA1Managed())\n                {\n                    byte[] hash = SHA1.ComputeHash(data);\n                    return rsaProvider.VerifyHash(hash, CryptoConfig.MapNameToOID("SHA1"), signature);\n                }\n            }\n        }\n    }\n}