using DocumentFormat.OpenXml.Packaging;\nusing DocumentFormat.OpenXml.Wordprocessing;\n\npublic ActionResult GenerateWord()\n{\n    using (MemoryStream stream = new MemoryStream())\n    {\n        using (WordprocessingDocument wordDoc = WordprocessingDocument.Create(stream, DocumentFormat.OpenXml.WordprocessingDocumentType.Document, true))\n        {\n            MainDocumentPart mainPart = wordDoc.AddMainDocumentPart();\n            mainPart.Document = new Document();\n            Body body = mainPart.Document.AppendChild(new Body());\n\n            // Add content to the Word document\n            body.Append(new Paragraph(new Run(new Text("Hello, this is a sample Word letter."))));\n            body.Append(new Paragraph(new Run(new Text("Name: John Doe"))));\n            body.Append(new Paragraph(new Run(new Text("Address: 1234 Main St."))));\n\n            mainPart.Document.Save();\n        }\n\n        byte[] file = stream.ToArray();\n        \n        // Return the Word file as a download\n        return File(file, "application/vnd.openxmlformats-officedocument.wordprocessingml.document", "Letter.docx");\n    }\n}