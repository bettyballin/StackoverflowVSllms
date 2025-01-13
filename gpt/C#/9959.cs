RSASender sender = new RSASender();\nRSAReceiver receiver = new RSAReceiver();\n\n// Exchange public keys\nstring senderPublicKey = sender.GetPublicKey();\nstring receiverPublicKey = receiver.GetPublicKey();\n\n// Sender encrypts and signs data\nstring message = "Hello, secure world!";\nbyte[] encryptedData = sender.Encrypt(message, receiverPublicKey);\nbyte[] signature = sender.SignData(encryptedData);\n\n// Receiver decrypts and verifies data\nreceiver.SetPrivateKey("<receiver_private_key_xml>");\nstring decryptedMessage = receiver.Decrypt(encryptedData);\nbool isVerified = receiver.VerifySignature(encryptedData, signature, senderPublicKey);\n\nConsole.WriteLine($"Decrypted Message: {decryptedMessage}");\nConsole.WriteLine($"Signature Verified: {isVerified}");