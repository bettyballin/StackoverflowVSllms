using System;\nusing System.Security.Cryptography;\nusing System.Text;\n\nnamespace Agnus.Cipher\n{\n    public class RSA\n    {\n        private byte[] plaintextBytes;\n        private byte[] ciphertextBytes;\n        private RSACryptoServiceProvider rSAProviderThis;\n        private RSACryptoServiceProvider rSAProviderOther;\n\n        public string PublicKey\n        {\n            get { return rSAProviderThis.ToXmlString(false); }\n        }\n\n        public RSA()\n        {\n            rSAProviderThis = new RSACryptoServiceProvider { PersistKeyInCsp = true };\n        }\n\n        public void InitializeRSAProviderOther(string parameters)\n        {\n            rSAProviderOther.FromXmlString(parameters);\n        }\n\n        public byte[] Encrypt(byte[] plaintext)\n        {\n            return rSAProviderThis.Encrypt(plaintext, true);\n        }\n\n        public byte[] Decrypt(byte[] ciphertext)\n        {\n            return rSAProviderThis.Decrypt(ciphertext, true);\n        }\n\n        public byte[] Sign(byte[] data)\n        {\n            using (var sha256 = SHA256.Create())\n            {\n                byte[] hash = sha256.ComputeHash(data);\n                byte[] signature = rSAProviderThis.SignHash(hash, "SHA256");\n                return signature;\n            }\n        }\n\n        public bool Verify(byte[] data, byte[] signature)\n        {\n            using (var sha256 = SHA256.Create())\n            {\n                byte[] hash = sha256.ComputeHash(data);\n                return rSAProviderThis.VerifyHash(hash, "SHA256", signature);\n            }\n        }\n    }\n}