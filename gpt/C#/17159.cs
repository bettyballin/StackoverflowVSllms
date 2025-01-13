using System;\nusing System.Collections;\nusing Org.BouncyCastle.Cms;\nusing Org.BouncyCastle.Crypto;\nusing Org.BouncyCastle.Crypto.Generators;\nusing Org.BouncyCastle.Security;\nusing Org.BouncyCastle.Utilities.IO;\nusing Org.BouncyCastle.X509;\n\npublic void TestMethod1()\n{\n    byte[] data = new byte[1024]; // plaintext: a list of zeroes\n\n    // Initialize the generator\n    CmsEnvelopedDataGenerator generator = new CmsEnvelopedDataGenerator();\n\n    // Create a password-based encryption key\n    char[] password = "foo".ToCharArray();\n    byte[] salt = new byte[] { 1, 2, 3 };\n    int iterationCount = 2048;\n    CmsPbeKey encryptionKey = new Pkcs5Scheme2PbeKey(password, salt, iterationCount);\n\n    // Add the password recipient - using AES-GCM for authenticated encryption\n    generator.AddPasswordRecipient(encryptionKey, CmsEnvelopedDataGenerator.Aes256Gcm);\n\n    // Create the CMS processable data object\n    CmsProcessableByteArray cmsByteArray = new CmsProcessableByteArray(data);\n\n    // Generate the enveloped data\n    CmsEnvelopedData envelopeData = generator.Generate(cmsByteArray, CmsEnvelopedDataGenerator.Aes256Gcm);\n\n    // Encode the enveloped data to a byte array\n    byte[] encodedData = envelopeData.GetEncoded();\n\n    // Optionally tamper with the data to test authentication (uncomment to test)\n    // encodedData[500] = 10; // tamper with the data\n\n    // Decrypt the data\n    RecipientID recipientID = new RecipientID();\n    CmsEnvelopedData decodedEnvelopeData = new CmsEnvelopedData(encodedData);\n    RecipientInformation recipient = decodedEnvelopeData.GetRecipientInfos().GetFirstRecipient(recipientID);\n\n    // Extract the content\n    byte[] data2 = recipient.GetContent(encryptionKey);\n\n    // Validate the content matches the original data\n    if (StructuralComparisons.StructuralEqualityComparer.Equals(data, data2))\n    {\n        Console.WriteLine("Data matches");\n    }\n    else\n    {\n        Console.WriteLine("Data does not match");\n    }\n}