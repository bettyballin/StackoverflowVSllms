var privateKey = @"-----BEGIN RSA PRIVATE KEY-----\n{ the full PEM private key } \n-----END RSA PRIVATE KEY-----";\n\nvar rsa = RSA.Create();\nrsa.ImportFromPem(privateKey.ToCharArray());\n\nvar decryptedBytes = rsa.Decrypt(\n    Convert.FromBase64String("{ base64-encoded encrypted string }"), \n    RSAEncryptionPadding.Pkcs1\n);\n\n// this will print the original unencrypted string\nConsole.WriteLine(Encoding.UTF8.GetString(decryptedBytes));