using System.IO;\nusing DocumentFormat.OpenXml.Packaging;\n\npublic void SetPassword(string filePath, string password)\n{\n    using (WordprocessingDocument wordDoc = WordprocessingDocument.Open(filePath, true))\n    {\n        if (!wordDoc.HasEncryptedPackage)\n            EncryptionHelper.SetPassword(wordDoc, password);\n    }\n}