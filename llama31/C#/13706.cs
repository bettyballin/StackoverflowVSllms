using DocumentFormat.OpenXml;\nusing DocumentFormat.OpenXml.Packaging;\nusing DocumentFormat.OpenXml.Wordprocessing;\n\n// Open a Word document\nusing (WordprocessingDocument wordDocument = WordprocessingDocument.Open("example.docx", true)) {\n    // Get the main document part\n    MainDocumentPart mainPart = wordDocument.MainDocumentPart;\n    \n    // Get the text of the first paragraph\n    string text = mainPart.Document.Body.Elements<Paragraph>().First().InnerText;\n}