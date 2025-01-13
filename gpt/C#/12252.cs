// Reading RTF\nusing System.Windows.Forms;\nusing System.IO;\n\nstring ReadRtf(string filePath)\n{\n    var richTextBox = new RichTextBox();\n    richTextBox.LoadFile(filePath);\n    return richTextBox.Text;\n}\n\n// Reading PDF using PdfSharp\nusing PdfSharp.Pdf;\nusing PdfSharp.Pdf.IO;\n\nstring ReadPdf(string filePath)\n{\n    using (PdfDocument document = PdfReader.Open(filePath, PdfDocumentOpenMode.ReadOnly))\n    {\n        StringBuilder text = new StringBuilder();\n        foreach (PdfPage page in document.Pages)\n        {\n            text.Append(PdfSharp.TextExtractor.ExtractText(page));\n        }\n        return text.ToString();\n    }\n}\n\n// Reading HTML using HtmlAgilityPack\nusing HtmlAgilityPack;\n\nstring ReadHtml(string filePath)\n{\n    var doc = new HtmlDocument();\n    doc.Load(filePath);\n    return doc.DocumentNode.InnerText;\n}\n\n// Reading MS Word using OpenXml SDK\nusing DocumentFormat.OpenXml.Packaging;\n\nstring ReadWord(string filePath)\n{\n    using (WordprocessingDocument wordDoc = WordprocessingDocument.Open(filePath, false))\n    {\n        return wordDoc.MainDocumentPart.Document.Body.InnerText;\n    }\n}