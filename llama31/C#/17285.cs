using Microsoft.SharePoint;\nusing System.IO;\nusing System.Security.Cryptography;\n\nnamespace SharePointEncryption\n{\n    public class ListEncryptor\n    {\n        public void EncryptList(SPList list)\n        {\n            // Create a new encryption key\n            Aes encryptionKey = Aes.Create();\n            encryptionKey.GenerateKey();\n\n            // Encrypt each item in the list\n            foreach (SPListItem item in list.Items)\n            {\n                // Get the item's file\n                SPFile file = item.File;\n\n                // Encrypt the file's contents\n                byte[] encryptedBytes = EncryptFile(file.OpenBinary(), encryptionKey);\n\n                // Update the item's file with the encrypted contents\n                file.SaveBinaryDirect(encryptedBytes);\n            }\n        }\n\n        public void DecryptList(SPList list)\n        {\n            // Create a new decryption key\n            Aes decryptionKey = Aes.Create();\n            decryptionKey.GenerateKey();\n\n            // Decrypt each item in the list\n            foreach (SPListItem item in list.Items)\n            {\n                // Get the item's file\n                SPFile file = item.File;\n\n                // Decrypt the file's contents\n                byte[] decryptedBytes = DecryptFile(file.OpenBinary(), decryptionKey);\n\n                // Update the item's file with the decrypted contents\n                file.SaveBinaryDirect(decryptedBytes);\n            }\n        }\n\n        private byte[] EncryptFile(byte[] fileBytes, Aes encryptionKey)\n        {\n            // Create a new MemoryStream\n            MemoryStream ms = new MemoryStream();\n\n            // Create a new CryptoStream\n            CryptoStream cs = new CryptoStream(ms, encryptionKey.CreateEncryptor(), CryptoStreamMode.Write);\n\n            // Write the file bytes to the CryptoStream\n            cs.Write(fileBytes, 0, fileBytes.Length);\n            cs.FlushFinalBlock();\n\n            // Return the encrypted bytes\n            return ms.ToArray();\n        }\n\n        private byte[] DecryptFile(byte[] fileBytes, Aes decryptionKey)\n        {\n            // Create a new MemoryStream\n            MemoryStream ms = new MemoryStream(fileBytes);\n\n            // Create a new CryptoStream\n            CryptoStream cs = new CryptoStream(ms, decryptionKey.CreateDecryptor(), CryptoStreamMode.Read);\n\n            // Read the decrypted bytes from the CryptoStream\n            byte[] decryptedBytes = new byte[fileBytes.Length];\n            cs.Read(decryptedBytes, 0, decryptedBytes.Length);\n\n            // Return the decrypted bytes\n            return decryptedBytes;\n        }\n    }\n}