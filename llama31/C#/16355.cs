public void TestMethod1()\n{\n    byte[] data = new byte[1024]; // plaintext: a list of zeroes\n\n    CmsEnvelopedDataGenerator generator = new CmsEnvelopedDataGenerator();\n    CmsPbeKey encryptionKey = new Pkcs5Scheme2PbeKey("foo", new byte[] { 1, 2, 3 }, 2048);\n    generator.AddPasswordRecipient(encryptionKey, CmsEnvelopedDataGenerator.Aes256CbcWithHmacSha256);\n    CmsProcessableByteArray cmsByteArray = new CmsProcessableByteArray(data);\n    CmsEnvelopedData envelopeData = generator.Generate(cmsByteArray, CmsEnvelopedDataGenerator.Aes256CbcWithHmacSha256);\n\n    byte[] encodedData = envelopeData.GetEncoded();\n\n    // tamper with the data\n    encodedData[500] = 10;\n\n    RecipientID recipientID = new RecipientID();\n    CmsEnvelopedData decodedEnvelopeData = new CmsEnvelopedData(encodedData);\n    RecipientInformation recipient = decodedEnvelopeData.GetRecipientInfos().GetFirstRecipient(recipientID);\n\n    try\n    {\n        byte[] data2 = recipient.GetContent(encryptionKey);\n        CollectionAssert.AreEqual(data, data2);\n    }\n    catch (Exception ex)\n    {\n        // HMAC verification failed, data has been tampered with\n    }\n}