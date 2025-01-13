using iTextSharp.text;\nusing iTextSharp.text.pdf;\nusing System.IO;\n\npublic byte[] ConvertDocumentToByteArray()\n{\n    using (MemoryStream memoryStream = new MemoryStream())\n    {\n        Document document = new Document();\n        PdfWriter writer = PdfWriter.GetInstance(document, memoryStream);\n        document.Open();\n\n        // Add content to the document here\n        document.Add(new Paragraph("Hello, World!"));\n\n        document.Close();\n        writer.Close();\n\n        return memoryStream.ToArray();\n    }\n}