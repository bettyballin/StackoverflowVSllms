/// Encrypt the SIP IP address in the remote server\nprivate void encryptSIP_IP(string sip_ip)\n{\n    TripleDESCryptoServiceProvider encrypt = new TripleDESCryptoServiceProvider();\n\n    // Private key\n    byte[] key = { 0, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 144, 89, 55, 34, 21, 13, 8, 5, 3, 2, 1, 0 };\n\n    encrypt.Key = key;\n    byte[] byteSIP = System.Text.Encoding.UTF8.GetBytes(sip_ip);\n\n    ICryptoTransform encryptor = encrypt.CreateEncryptor();\n    byte[] encrypted_sip = encryptor.TransformFinalBlock(byteSIP, 0, byteSIP.Length);\n}\n\n/// This will decrypt in the client application\nprivate void decryptSIP_IP(byte[] encrypted_sip)\n{\n    TripleDESCryptoServiceProvider decrypt = new TripleDESCryptoServiceProvider();\n\n    // Private key\n    byte[] key = { 0, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 144, 89, 55, 34, 21, 13, 8, 5, 3, 2, 1, 0 };\n\n    decrypt.Key = key;\n    ICryptoTransform decryptor = decrypt.CreateDecryptor();\n\n    byte[] original = decryptor.TransformFinalBlock(encrypted_sip, 0, encrypted_sip.Length);\n    string ip = System.Text.Encoding.UTF8.GetString(original);\n}